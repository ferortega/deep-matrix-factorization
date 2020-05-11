package com.github.ferortega.deepmf;

import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.data.DataSet;
import es.upm.etsisi.cf4j.data.RandomSplitDataSet;
import es.upm.etsisi.cf4j.qualityMeasure.QualityMeasure;
import es.upm.etsisi.cf4j.qualityMeasure.prediction.MAE;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Playground {

    private final static long RANDOM_SEED = 43;

    private final static int[] NUM_FACTORS = {10, 10, 10};
    private final static boolean[] BIASED = {true, true, true};
    private final static int[] NUM_ITERS = {100, 100, 100};
    private final static double[] LEARNING_RATE = {0.01, 0.01, 0.01};
    private final static double[] REGULARIZATION = {0.055, 0.055, 0.055};

    public static void main(String[] args) throws IOException {
//        DataSet ml1m = new RandomSplitDataSet("src/main/resources/ratings.dat", 0.2, 0.2, "::", RANDOM_SEED);
//        DataModel datamodel = new DataModel(ml1m);
//
//        DeepMF deepmf = new DeepMF(datamodel, NUM_FACTORS, BIASED, NUM_ITERS, LEARNING_RATE, REGULARIZATION, RANDOM_SEED);
//        deepmf.fit();
//
//        QualityMeasure mae = new MAE(deepmf);
//        System.out.println("\nMAE: " + mae.getScore());

        Boolean[] biased = {true, false};

        Boolean[][] params = getParams(2, biased);

        for (int i = 0; i < params.length; i++) {
            System.out.println(Arrays.toString(params[i]));
        }
    }


    private static <T> T[][] getParams(int depth, T[] values) {
        int numParams = (int) Math.pow(values.length, depth);

        T[][] params = (T[][]) Array.newInstance(values[0].getClass(), numParams, depth);

        for (int d = 0; d < depth; d++) {
            int numReps = d > 0 ? (int) Math.pow(2, d - 1) * values.length : 1;

            int index = 0;

            while (index < numParams) {
                for (int n = 0; n < values.length; n++) {
                    for (int r = 0; r < numReps; r++) {
                        params[index][depth - d - 1] = values[n];
                        index++;
                    }
                }
            }
        }

        return params;
    }
}
