package com.github.ferortega.deepmf.experiments;

import es.upm.etsisi.cf4j.data.BenchmarkDataModels;
import es.upm.etsisi.cf4j.data.DataModel;

import java.util.Map;

public class Settings {

    // Global settings
    public static final long RANDOM_SEED = 43;

    public static final int PLOT_WIDTH = 950;
    public static final int PLOT_HEIGHT = 534;

    // Dataset settings
    public static DataModel DATAMODEL = null;
    public static double LIKE_THRESHOLD;

    public static String EXPORT_PREFIX;

    // DeepMF parameters
    public static Map<String, Object> DEEPMF_PARAMS;

    // Baselines parameters
    public static Map<String, Object> PMF_PARAMS;
    public static Map<String, Object> NMF_PARAMS;
    public static Map<String, Object> SVDPP_PARAMS;

    // Uncomment this for MovieLens 100K
    static {
        try {
            DATAMODEL = BenchmarkDataModels.MovieLens100K();
            LIKE_THRESHOLD = 4.0;

            EXPORT_PREFIX = "ml100k";

            DEEPMF_PARAMS = Map.of(
                    "numFactors", new int[]{3, 3, 3, 3},
                    "numIters", new int[]{50, 50, 50, 50},
                    "learningRate", new double[]{0.01, 0.1, 0.01, 0.1},
                    "regularization", new double[]{0.1, 0.01, 0.1, 0.01},
                    "seed", RANDOM_SEED
            );

            PMF_PARAMS = Map.of(
                    "numFactors", 2,
                    "numIters", 50,
                    "gamma", 0.01,
                    "lambda", 0.025,
                    "seed", RANDOM_SEED
            );

            NMF_PARAMS = Map.of(
                    "numFactors", 2,
                    "numIters", 50,
                    "seed", RANDOM_SEED
            );

            SVDPP_PARAMS = Map.of(
                    "numFactors", 2,
                    "numIters", 50,
                    "lambda", 0.08,
                    "gamma", 0.0014,
                    "seed", RANDOM_SEED
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    // Uncomment this for MovieLens 1M
//    static {
//        try {
//            DATAMODEL = BenchmarkDataModels.MovieLens1M();
//            LIKE_THRESHOLD = 4.0;
//
//            EXPORT_PREFIX = "ml1m";
//
//            DEEPMF_PARAMS = Map.of(
//                    "numFactors", new int[]{9, 3, 3},
//                    "numIters", new int[]{50, 50, 50},
//                    "learningRate", new double[]{0.01, 0.01, 0.01},
//                    "regularization", new double[]{0.1, 0.01, 0.1},
//                    "seed", RANDOM_SEED
//            );
//
//            PMF_PARAMS = Map.of(
//                    "numFactors", 8,
//                    "numIters", 50,
//                    "gamma", 0.01,
//                    "lambda", 0.045,
//                    "seed", RANDOM_SEED
//            );
//
//            NMF_PARAMS = Map.of(
//                    "numFactors", 2,
//                    "numIters", 50,
//                    "seed", RANDOM_SEED
//            );
//
//            SVDPP_PARAMS = Map.of(
//                    "numFactors", 4,
//                    "numIters", 50,
//                    "lambda", 0.05,
//                    "gamma", 0.0014,
//                    "seed", RANDOM_SEED
//            );
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


//    // Uncomment this for FilmTrust
//    static {
//        try {
//            DATAMODEL = BenchmarkDataModels.FilmTrust();
//            LIKE_THRESHOLD = 3.5;
//
//            EXPORT_PREFIX = "ft";
//
//            DEEPMF_PARAMS = Map.of(
//                    "numFactors", new int[]{6, 6, 3},
//                    "numIters", new int[]{50, 50, 50},
//                    "learningRate", new double[]{0.01, 0.1, 0.01},
//                    "regularization", new double[]{0.1, 0.01, 0.01},
//                    "seed", RANDOM_SEED
//            );
//
//            PMF_PARAMS = Map.of(
//                    "numFactors", 4,
//                    "numIters", 50,
//                    "gamma", 0.015,
//                    "lambda", 0.1,
//                    "seed", RANDOM_SEED
//            );
//
//            NMF_PARAMS = Map.of(
//                    "numFactors", 2,
//                    "numIters", 50,
//                    "seed", RANDOM_SEED
//            );
//
//            SVDPP_PARAMS = Map.of(
//                    "numFactors", 2,
//                    "numIters", 50,
//                    "lambda", 0.1,
//                    "gamma", 0.0014,
//                    "seed", RANDOM_SEED
//            );
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


//    // Uncomment this for MyAnimeList
//    static {
//        try {
//            DATAMODEL = BenchmarkDataModels.MyAnimeList();
//            LIKE_THRESHOLD = 7.0;
//
//            EXPORT_PREFIX = "anime";
//
//            DEEPMF_PARAMS = Map.of(
//                    "numFactors", new int[]{9, 6, 9, 6},
//                    "numIters", new int[]{50, 50, 50, 50},
//                    "learningRate", new double[]{0.01, 0.1, 0.01, 0.1},
//                    "regularization", new double[]{0.1, 0.01, 0.1, 0.01},
//                    "seed", RANDOM_SEED
//            );
//
//            PMF_PARAMS = Map.of(
//                    "numFactors", 10,
//                    "numIters", 50,
//                    "gamma", 0.005,
//                    "lambda", 0.085,
//                    "seed", RANDOM_SEED
//            );
//
//            NMF_PARAMS = Map.of(
//                    "numFactors", 2,
//                    "numIters", 50,
//                    "seed", RANDOM_SEED
//            );
//
//            SVDPP_PARAMS = Map.of(
//                    "numFactors", 4,
//                    "numIters", 50,
//                    "lambda", 0.02,
//                    "gamma", 0.0014,
//                    "seed", RANDOM_SEED
//            );
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
