package com.github.ferortega.deepmf.experiments;

import com.github.ferortega.deepmf.recommender.DeepMF;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.qualityMeasure.recommendation.Precision;
import es.upm.etsisi.cf4j.qualityMeasure.recommendation.Recall;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.NMF;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.PMF;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.SVDPlusPlus;
import es.upm.etsisi.cf4j.util.plot.XYPlot;

import java.io.IOException;

public class QualityOfRecommendations {

    final static int[] NUMBER_OF_RECOMMENDATIONS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) throws IOException {

        DataModel datamodel = Settings.DATAMODEL;

        String[] labels = new String[NUMBER_OF_RECOMMENDATIONS.length];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = String.valueOf(NUMBER_OF_RECOMMENDATIONS[i]);
        }

        XYPlot plot = new XYPlot(labels, "Recall", "Precision");


        DeepMF deepmf = new DeepMF(datamodel, Settings.DEEPMF_PARAMS);
        deepmf.fit();
        plot.addSeries("DeepMF");
        plot.setLabelsVisible("DeepMF");

        for (int N : NUMBER_OF_RECOMMENDATIONS) {
            Precision precision = new Precision(deepmf, N, Settings.LIKE_THRESHOLD);
            double precisionScore = precision.getScore();

            Recall recall = new Recall(deepmf, N, Settings.LIKE_THRESHOLD);
            double recallScore = recall.getScore();

            plot.setXY("DeepMF", String.valueOf(N), recallScore, precisionScore);
        }


        PMF pmf = new PMF(datamodel, Settings.PMF_PARAMS);
        pmf.fit();
        plot.addSeries("PMF");

        for (int N : NUMBER_OF_RECOMMENDATIONS) {
            Precision precision = new Precision(pmf, N, Settings.LIKE_THRESHOLD);
            double precisionScore = precision.getScore();

            Recall recall = new Recall(pmf, N, Settings.LIKE_THRESHOLD);
            double recallScore = recall.getScore();

            plot.setXY("PMF", String.valueOf(N), recallScore, precisionScore);
        }


        NMF nmf = new NMF(datamodel, Settings.NMF_PARAMS);
        nmf.fit();
        plot.addSeries("NMF");

        for (int N : NUMBER_OF_RECOMMENDATIONS) {
            Precision precision = new Precision(nmf, N, Settings.LIKE_THRESHOLD);
            double precisionScore = precision.getScore();

            Recall recall = new Recall(nmf, N, Settings.LIKE_THRESHOLD);
            double recallScore = recall.getScore();

            plot.setXY("NMF", String.valueOf(N), recallScore, precisionScore);
        }


        SVDPlusPlus svdpp = new SVDPlusPlus(datamodel, Settings.SVDPP_PARAMS);
        svdpp.fit();
        plot.addSeries("SVD++");

        for (int N : NUMBER_OF_RECOMMENDATIONS) {
            Precision precision = new Precision(svdpp, N, Settings.LIKE_THRESHOLD);
            double precisionScore = precision.getScore();

            Recall recall = new Recall(svdpp, N, Settings.LIKE_THRESHOLD);
            double recallScore = recall.getScore();

            plot.setXY("SVD++", String.valueOf(N), recallScore, precisionScore);
        }


        plot.draw();
        plot.exportPlot("exports/" + Settings.EXPORT_PREFIX + "-precision-recall.png");
        plot.printData();
        plot.exportData("exports/" + Settings.EXPORT_PREFIX + "-precision-recall.csv");
    }
}
