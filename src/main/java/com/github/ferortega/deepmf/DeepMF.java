package com.github.ferortega.deepmf;

import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.data.Item;
import es.upm.etsisi.cf4j.data.User;
import es.upm.etsisi.cf4j.recommender.Recommender;
import es.upm.etsisi.cf4j.util.Maths;
import es.upm.etsisi.cf4j.util.process.Parallelizer;
import es.upm.etsisi.cf4j.util.process.Partible;

import java.util.Arrays;
import java.util.Random;

public class DeepMF extends Recommender {

    private double [] learningRate;
    private double [] regularization;
    private int [] numIters;

    private int [] numFactors;

    private int depth;

    private long seed;

    double[][] userFactors;
    double[][] itemFactors;

    private double average;

    private DeepMF parent;
    private DeepMF child;

    public DeepMF(DataModel datamodel, int[] numFactors,int[] numIters, double[] learningRate, double[] regularization) {
        this(datamodel, numFactors, numIters, learningRate, regularization, 0, null, System.currentTimeMillis());
    }

    public DeepMF(DataModel datamodel, int[] numFactors, int[] numIters, double[] learningRate, double[] regularization, long seed) {
        this(datamodel, numFactors, numIters, learningRate, regularization, 0, null, seed);
    }

    private DeepMF(DataModel datamodel, int[] numFactors, int[] numIters, double[] learningRate, double[] regularization, int depth, DeepMF parent, long seed) {
        super(datamodel);

        this.numFactors = numFactors;
        this.depth = depth;

        this.numIters = numIters;
        this.learningRate = learningRate;
        this.regularization = regularization;

        this.parent = parent;
        this.child = null;

        this.seed = seed;
        Random rand = new Random(seed);

        int numUsers = datamodel.getNumberOfUsers();
        this.userFactors = new double[numUsers][this.getNumFactors()];

        for (int userIndex = 0; userIndex < datamodel.getNumberOfUsers(); userIndex++) {
            for (int f = 0; f < this.getNumFactors(); f++) {
                this.userFactors[userIndex][f] = rand.nextDouble();
            }
        }

        int numItems = datamodel.getNumberOfItems();
        this.itemFactors = new double[numItems][this.getNumFactors()];

        for (int itemIndex = 0; itemIndex < datamodel.getNumberOfItems(); itemIndex++) {
            for (int f = 0; f < this.getNumFactors(); f++) {
                this.itemFactors[itemIndex][f] = rand.nextDouble();
            }
        }


        double sum = 0;
        int count = 0;

        for (int userIndex = 0; userIndex < datamodel.getNumberOfUsers(); userIndex++) {
            User user = datamodel.getUser(userIndex);
            for (int pos = 0; pos < user.getNumberOfRatings(); pos++) {
                int itemIndex = user.getItemAt(pos);
                sum += this.getValue(userIndex, itemIndex);
                count++;
            }
        }

        this.average = sum / count;
    }


    public void fit() {

        for (int iter = 1; iter <= this.getNumIters(); iter++) {
            Parallelizer.exec(datamodel.getUsers(), new UpdateUsersFactors());
            Parallelizer.exec(datamodel.getItems(), new UpdateItemsFactors());
        }

        if (this.depth < this.getMaxDepth() - 1) {
            this.child = new DeepMF(datamodel, this.numFactors, this.numIters, this.regularization, this.learningRate, this.depth + 1, this, seed);
            this.child.fit();
        }
    }

    private int getNumFactors() {
        return this.numFactors[this.depth];
    }

    private double getLearningRate() {
        return this.learningRate[this.depth];
    }

    private int getNumIters() {
        return this.numIters[this.depth];
    }

    private double getRegularization() {
        return this.regularization[this.depth];
    }

    private int getMaxDepth() {
        return this.numFactors.length;
    }

    private boolean hasParent() {
        return this.parent != null;
    }

    private boolean hasChild() {
        return this.child != null;
    }

    private double getValue (int userIndex, int itemIndex) {
        if (this.hasParent()) {
            double value = this.parent.getValue(userIndex, itemIndex);
            double estimation = this.parent.getEstimation(userIndex, itemIndex);
            return value - estimation; // error
        } else {
            User user = datamodel.getUser(userIndex);
            int pos = user.findItem(itemIndex);
            return user.getRatingAt(pos);
        }
    }

    private double getEstimation (int userIndex, int itemIndex) {
        return Maths.dotProduct(this.userFactors[userIndex], this.itemFactors[itemIndex]);
    }

    public double predict(int userIndex, int itemIndex) {
        if (this.hasChild()) {
            return this.getEstimation(userIndex, itemIndex) + this.child.predict(userIndex, itemIndex);
        } else {
            return this.getEstimation(userIndex, itemIndex);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("DeepMF(")
                .append("numFactors=").append(Arrays.toString(this.numFactors))
                .append("; ")
                .append("numIters=").append(Arrays.toString(this.numIters))
                .append("; ")
                .append("learningRate=").append(Arrays.toString(this.learningRate))
                .append("; ")
                .append("regularization=").append(Arrays.toString(this.regularization))
                .append(")");
        return str.toString();
    }

    private class UpdateUsersFactors implements Partible<User> {

        @Override
        public void beforeRun() { }

        @Override
        public void run(User user) {
            int userIndex = user.getUserIndex();

            for (int pos = 0; pos < user.getNumberOfRatings(); pos++) {
                int itemIndex = user.getItemAt(pos);

                double value = getValue(userIndex, itemIndex);
                double estimation = getEstimation(userIndex, itemIndex);

                double error = value - estimation;

                for (int f = 0; f < DeepMF.this.getNumFactors(); f++)	{
                    userFactors[userIndex][f] += getLearningRate() * (error * itemFactors[itemIndex][f] - getRegularization() * userFactors[userIndex][f]);
                }
            }
        }

        @Override
        public void afterRun() { }
    }


    private class UpdateItemsFactors implements Partible<Item> {

        @Override
        public void beforeRun() { }

        @Override
        public void run(Item item) {
            int itemIndex = item.getItemIndex();

            for (int pos = 0; pos < item.getNumberOfRatings(); pos++) {
                int userIndex = item.getUserAt(pos);

                double value = getValue(userIndex, itemIndex);
                double estimation = getEstimation(userIndex, itemIndex);

                double error = value - estimation;

                for (int f = 0; f < DeepMF.this.getNumFactors(); f++) {
                    itemFactors[itemIndex][f] += getLearningRate() * (error * userFactors[userIndex][f] - getRegularization() * itemFactors[itemIndex][f]);
                }
            }
        }

        @Override
        public void afterRun() { }
    }
}

