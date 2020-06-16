package com.github.ferortega.deepmf.experiments;

import com.github.ferortega.deepmf.recommender.DeepMF;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.qualityMeasure.QualityMeasure;
import es.upm.etsisi.cf4j.qualityMeasure.prediction.MAE;
import org.apache.commons.math3.util.Pair;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DeepMfGridSearch {

    private static int[] DEPTHS = {1, 2, 3, 4};

    private static Integer[] NUM_FACTORS = {3, 6, 9};
    private static Double[] LEARNING_RATE = {0.01, 0.1};
    private static Double[] REGULARIZATION = {0.01, 0.1};

    private static int NUM_ITERS = 50;

    public static void main (String [] args) throws IOException {

        DataModel datamodel = Settings.DATAMODEL;

        List<Pair<String, Double>> results = new ArrayList<>();

        int developmentSetSize = 0;

        for (int i = 0; i < DEPTHS.length; i++) {
            developmentSetSize += Math.pow(NUM_FACTORS.length * LEARNING_RATE.length * REGULARIZATION.length, i+1);
        }

        int count = 0;

        for (int depth : DEPTHS) {

            int[] numIters = new int[depth];
            Arrays.fill(numIters, NUM_ITERS);

            for(Double[] learningRate : getParams(depth, LEARNING_RATE)) {

                for (Double[] regularization : getParams(depth, REGULARIZATION)) {

                    for(Integer[] numFactors : getParams(depth, NUM_FACTORS)) {

                        count++;

                        DecimalFormat df = new DecimalFormat("0.0000");
                        double complete = 100 * (double) count / (double) developmentSetSize;

                        DeepMF deepmf = new DeepMF(datamodel, toIntArray(numFactors), numIters, toDoubleArray(learningRate), toDoubleArray(regularization), Settings.RANDOM_SEED);

                        System.out.println("[Evaluation " + count + " of " + developmentSetSize + "; " + df.format(complete) + "%] " + deepmf.toString());

                        deepmf.fit();

                        QualityMeasure mae = new MAE(deepmf);
                        double score =  mae.getScore();

                        if (Double.isNaN(score) || Double.isInfinite(score)) {
                            score = Double.MAX_VALUE;
                        }

                        results.add(new Pair<String, Double>(deepmf.toString(), score));
                    }
                }
            }
        }

        Comparator<Pair<String, Double>> comparator = Comparator.comparing(Pair::getValue, (v1, v2) -> {
            if (v1 > v2) {
                return 1;
            } else if (v2 > v1) {
                return -1;
            } else {
                return 0;
            }
        });

        results.sort(comparator);

        System.out.println("\nTuning parameters for DeepMF recommender:\n\nBest parameters set found on development set:\n\n"
                + results.get(0).getKey()
                + "\n\nMAE scores on development set:\n");

        for (Pair<String, Double> result : results) {
            System.out.println(result.getValue() + " for " + result.getKey());
        }
    }

    private static <T> T[][] getParams(int depth, T[] values) {
        int numParams = (int) Math.pow(values.length, depth);
        T[][] params = (T[][]) Array.newInstance(values[0].getClass(), numParams, depth);

        for (int d = 0; d < depth; d++) {
            int index = 0;
            while (index < numParams) {
                for (int n = 0; n < values.length; n++) {
                    for (int r = 0; r < (int) Math.pow(values.length, depth - d -1); r++) {
                        params[index][d] = values[n];
                        index++;
                    }
                }
            }
        }

        return params;
    }

    private static int[] toIntArray(Integer[] values) {
        int[] array = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    private static double[] toDoubleArray(Double[] values) {
        double[] array = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    private static boolean[] toBooleanArray(Boolean[] values) {
        boolean[] array = new boolean[values.length];
        for (int i = 0; i < values.length; i++) {
            array[i] = values[i];
        }
        return array;
    }
}
