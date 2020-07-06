package com.github.ferortega.deepmf.experiments;

import es.upm.etsisi.cf4j.data.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportFAuSTDatasets {

    public static void main (String[] args) throws IOException {

        DataModel datamodel = BenchmarkDataModels.MovieLens100K();

        File trainFile = new File("ml100k_train.csv");
        PrintWriter trainWriter = new PrintWriter(trainFile);

        for (int userIndex = 0; userIndex < datamodel.getNumberOfUsers(); userIndex++) {
            User user = datamodel.getUser(userIndex);

            for (int itemIndex = 0; itemIndex < datamodel.getNumberOfItems(); itemIndex++) {
                int pos = user.findItem(itemIndex);

                if (pos == -1) {
                    trainWriter.print("-1");
                } else {
                    trainWriter.print(user.getRatingAt(pos));
                }

                if (itemIndex == datamodel.getNumberOfItems()-1) {
                    trainWriter.println();
                } else {
                    trainWriter.print(",");
                }
            }
        }

        trainWriter.close();


        File testFile = new File("ml100k_test.csv");
        PrintWriter testWriter = new PrintWriter(testFile);

        for (int userIndex = 0; userIndex < datamodel.getNumberOfUsers(); userIndex++) {
            User user = datamodel.getUser(userIndex);

            int testUserIndex = datamodel.findTestUserIndex(user.getId());

            for (int itemIndex = 0; itemIndex < datamodel.getNumberOfItems(); itemIndex++) {
                Item item = datamodel.getItem(itemIndex);

                int testItemIndex = datamodel.findTestItemIndex(item.getId());

                if (testUserIndex != -1 && testItemIndex != -1) {
                    TestUser testUser = datamodel.getTestUser(testUserIndex);

                    int pos = findTestItem(testUser, testItemIndex);

                    if (pos == -1) {
                        testWriter.print("-1");
                    } else {
                        testWriter.print(testUser.getTestRatingAt(pos));
                    }

                } else {
                    testWriter.print("-1");
                }

                if (itemIndex == datamodel.getNumberOfItems()-1) {
                    testWriter.println();
                } else {
                    testWriter.print(",");
                }
            }
        }

        testWriter.close();
    }


    private static int findTestItem (TestUser testUser, int testItemIndex) {
        int pos = 0;
        while (pos < testUser.getNumberOfTestRatings() && testUser.getTestItemAt(pos) != testItemIndex) pos++;
        if (pos == testUser.getNumberOfTestRatings()) {
            return -1;
        } else {
            return pos;
        }
    }
}
