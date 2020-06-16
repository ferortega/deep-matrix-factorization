package com.github.ferortega.deepmf.experiments;

import com.github.ferortega.deepmf.util.plot.CustomLinePlot;
import com.github.ferortega.deepmf.recommender.DeepMF;
import es.upm.etsisi.cf4j.data.BenchmarkDataModels;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.data.User;

import java.io.IOException;
import java.util.Arrays;

public class PredictionAverage {

    public static void main (String[] args) throws IOException {

        int[] depths = {1, 2, 3, 4};


        // MovieLens 100K

        CustomLinePlot ml100kPlot = new CustomLinePlot(depths, "Depth", "Prediction average", 3.0);

        DataModel ml100k = BenchmarkDataModels.MovieLens100K();

        double[] avg = getPredictionAverage(ml100k, new int[]{3, 3, 3, 3}, new int[]{50, 50, 50, 50}, new double[]{0.01, 0.1, 0.01, 0.1}, new double[]{0.1, 0.01, 0.1, 0.01});
        ml100kPlot.addSeries("Rank 1", fixSize(avg, depths.length));

        avg = getPredictionAverage(ml100k, new int[]{3, 3, 3, 9}, new int[]{50, 50, 50, 50}, new double[]{0.01, 0.1, 0.01, 0.1}, new double[]{0.1, 0.01, 0.1, 0.01});
        ml100kPlot.addSeries("Rank 2", fixSize(avg, depths.length));

        avg = getPredictionAverage(ml100k, new int[]{3, 6, 6, 3}, new int[]{50, 50, 50, 50}, new double[]{0.01, 0.1, 0.01, 0.1}, new double[]{0.1, 0.01, 0.1, 0.01});
        ml100kPlot.addSeries("Rank 3", fixSize(avg, depths.length));

        avg = getPredictionAverage(ml100k, new int[]{3, 3, 3}, new int[]{50, 50, 50}, new double[]{0.01, 0.1, 0.01}, new double[]{0.1, 0.01, 0.1});
        ml100kPlot.addSeries("Rank 4", fixSize(avg, depths.length));

        avg = getPredictionAverage(ml100k, new int[]{3, 3, 9, 9}, new int[]{50, 50, 50, 50}, new double[]{0.01, 0.1, 0.01, 0.1}, new double[]{0.1, 0.01, 0.1, 0.01});
        ml100kPlot.addSeries("Rank 5", fixSize(avg, depths.length));

        ml100kPlot.draw();
        ml100kPlot.exportPlot("exports/ml100k-prediction-average.png");


        // MovieLens 1M

        CustomLinePlot ml1mPlot = new CustomLinePlot(depths, "Depth", "Prediction average", 5.0);

        DataModel ml1m = BenchmarkDataModels.MovieLens1M();

        avg = getPredictionAverage(ml1m, new int[]{9, 3, 3}, new int[]{50, 50, 50}, new double[]{0.01, 0.01, 0.01}, new double[]{0.1, 0.01, 0.1});
        ml1mPlot.addSeries("Rank 1", fixSize(avg, depths.length));

        avg = getPredictionAverage(ml1m, new int[]{9, 3, 9, 3}, new int[]{50, 50, 50, 50}, new double[]{0.01, 0.01, 0.01, 0.1}, new double[]{0.1, 0.01, 0.1, 0.01});
        ml1mPlot.addSeries("Rank 2", fixSize(avg, depths.length));

        avg = getPredictionAverage(ml1m, new int[]{9, 3, 9}, new int[]{50, 50, 50}, new double[]{0.01, 0.01, 0.01}, new double[]{0.1, 0.01, 0.1});
        ml1mPlot.addSeries("Rank 3", fixSize(avg, depths.length));

        avg = getPredictionAverage(ml1m, new int[]{9, 3, 3, 9}, new int[]{50, 50, 50, 50}, new double[]{0.01, 0.01, 0.01, 0.1}, new double[]{0.1, 0.01, 0.1, 0.01});
        ml1mPlot.addSeries("Rank 4", fixSize(avg, depths.length));

        avg = getPredictionAverage(ml1m, new int[]{9, 3, 3, 3}, new int[]{50, 50, 50, 50}, new double[]{0.01, 0.01, 0.01, 0.1}, new double[]{0.1, 0.01, 0.1, 0.01});
        ml1mPlot.addSeries("Rank 5", fixSize(avg, depths.length));

        ml1mPlot.draw();
        ml1mPlot.exportPlot("exports/ml1m-prediction-average.png");


        // FilmTrust

        CustomLinePlot ftPlot = new CustomLinePlot(depths, "Depth", "Prediction average", 3.0);

        DataModel ft = BenchmarkDataModels.FilmTrust();

        avg = getPredictionAverage(ft, new int[]{6, 6, 3}, new int[]{50, 50, 50}, new double[]{0.01, 0.1, 0.01}, new double[]{0.1, 0.01, 0.01});
        ftPlot.addSeries("Rank 1", fixSize(avg, depths.length));

        avg = getPredictionAverage(ft, new int[]{6, 6, 3}, new int[]{50, 50, 50}, new double[]{0.01, 0.1, 0.01}, new double[]{0.1, 0.01, 0.1});
        ftPlot.addSeries("Rank 2", fixSize(avg, depths.length));

        avg = getPredictionAverage(ft, new int[]{6, 3, 6}, new int[]{50, 50, 50}, new double[]{0.01, 0.1, 0.01}, new double[]{0.1, 0.01, 0.1});
        ftPlot.addSeries("Rank 3", fixSize(avg, depths.length));

        avg = getPredictionAverage(ft, new int[]{9, 3, 3}, new int[]{50, 50, 50}, new double[]{0.01, 0.1, 0.01}, new double[]{0.1, 0.01, 0.1});
        ftPlot.addSeries("Rank 4", fixSize(avg, depths.length));

        avg = getPredictionAverage(ft, new int[]{6, 6}, new int[]{50, 50}, new double[]{0.01, 0.01}, new double[]{0.1, 0.01});
        ftPlot.addSeries("Rank 5", fixSize(avg, depths.length));

        ftPlot.draw();
        ftPlot.exportPlot("exports/ft-prediction-average.png");


        // MyAnimeList

        CustomLinePlot animePlot = new CustomLinePlot(depths, "Depth", "Prediction average", 3.0);

        DataModel anime = BenchmarkDataModels.MyAnimeList();

        avg = getPredictionAverage(anime, new int[]{9, 6, 9, 6}, new int[]{50, 50, 50, 50}, new double[]{0.01, 0.1, 0.01, 0.1}, new double[]{0.1, 0.01, 0.1, 0.01});
        animePlot.addSeries("Rank 1", fixSize(avg, depths.length));

        avg = getPredictionAverage(anime, new int[]{9, 9, 6, 9}, new int[]{50, 50, 50, 50}, new double[]{0.01, 0.1, 0.01, 0.1}, new double[]{0.1, 0.01, 0.1, 0.01});
        animePlot.addSeries("Rank 2", fixSize(avg, depths.length));

        avg = getPredictionAverage(anime, new int[]{9, 6, 6, 6}, new int[]{50, 50, 50, 50}, new double[]{0.01, 0.1, 0.01, 0.1}, new double[]{0.1, 0.01, 0.1, 0.01});
        animePlot.addSeries("Rank 3", fixSize(avg, depths.length));

        avg = getPredictionAverage(anime, new int[]{9, 6, 6, 9}, new int[]{50, 50, 50, 50}, new double[]{0.01, 0.1, 0.01, 0.1}, new double[]{0.1, 0.01, 0.1, 0.01});
        animePlot.addSeries("Rank 4", fixSize(avg, depths.length));

        avg = getPredictionAverage(anime, new int[]{9, 9, 9, 6}, new int[]{50, 50, 50, 50}, new double[]{0.01, 0.1, 0.01, 0.1}, new double[]{0.1, 0.01, 0.1, 0.01});
        animePlot.addSeries("Rank 5", fixSize(avg, depths.length));

        animePlot.draw();
        animePlot.exportPlot("exports/anime-prediction-average.png");
    }

    private static double[] getPredictionAverage (DataModel datamodel, int[] numFactors, int[] numIters, double[] learningRate, double[] regularization) {

        DeepMF deepmf = new DeepMF(datamodel, numFactors, numIters, learningRate, regularization, Settings.RANDOM_SEED);
        deepmf.fit();

        double[] avg = new double[numFactors.length];

        for (int depth = 0; depth < numFactors.length; depth++) {

            double sum = 0;
            int count = 0;

            for (int userIndex = 0; userIndex < datamodel.getNumberOfUsers(); userIndex++) {
                User user = datamodel.getUser(userIndex);
                for (int pos = 0; pos < user.getNumberOfRatings(); pos++) {
                    int itemIndex = user.getItemAt(pos);
                    double estimation = deepmf.getEstimation(userIndex, itemIndex, depth);
                    sum += estimation;
                    count++;
                }
            }

            avg[depth] = Math.abs(sum / count);
        }

        System.out.println(Arrays.toString(avg));

        return avg;
    }

    private static double[] fixSize (double[] x, int length) {
        double[] values = new double[length];
        for (int i = 0; i < values.length; i++) {
            values[i] = (i < x.length) ? x[i] : Double.NaN;
        }
        return values;
    }
}
