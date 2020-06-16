package com.github.ferortega.deepmf.experiments;

import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.qualityMeasure.prediction.MAE;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.*;
import es.upm.etsisi.cf4j.util.optimization.GridSearch;
import es.upm.etsisi.cf4j.util.optimization.ParamsGrid;
import es.upm.etsisi.cf4j.util.Range;

import java.io.IOException;

public class BaselinesGridSearch {

    private final static int TOP_N = 10;

    public static void main(String[] args) throws IOException {

        DataModel datamodel = Settings.DATAMODEL;

        ParamsGrid paramsGrid;
        GridSearch gridSearch;

        // PMF Recommender

        paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{2, 4, 6, 8, 10});
        paramsGrid.addParam("lambda", Range.ofDoubles(0.005, 0.005, 20));
        paramsGrid.addParam("gamma", Range.ofDoubles(0.005, 0.005, 20));

        paramsGrid.addFixedParam("numIters", 50);
        paramsGrid.addFixedParam("seed", Settings.RANDOM_SEED);

        gridSearch = new GridSearch(datamodel, paramsGrid, es.upm.etsisi.cf4j.recommender.matrixFactorization.PMF.class, MAE.class);
        gridSearch.fit();
        gridSearch.printResults(TOP_N);


        // NMF Recommender

        paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{2, 4, 6, 8, 10});

        paramsGrid.addFixedParam("numIters", 50);
        paramsGrid.addFixedParam("seed", Settings.RANDOM_SEED);

        gridSearch = new GridSearch(datamodel, paramsGrid, NMF.class, MAE.class);
        gridSearch.fit();
        gridSearch.printResults(TOP_N);


        // SVDPlusPlus Recommender

        paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{2, 4, 6, 8, 10});
        paramsGrid.addParam("lambda", Range.ofDoubles(0.01, 0.01, 10));
        paramsGrid.addParam("gamma", Range.ofDoubles(0.0005, 0.0001, 10));

        paramsGrid.addFixedParam("numIters", 50);
        paramsGrid.addFixedParam("seed", Settings.RANDOM_SEED);

        gridSearch = new GridSearch(datamodel, paramsGrid, SVDPlusPlus.class, MAE.class);
        gridSearch.fit();
        gridSearch.printResults(TOP_N);
    }
}
