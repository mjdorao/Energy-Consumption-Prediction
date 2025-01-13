package org.example;

public class TrainTestSplitter {

    public double[][][] splitFeatures(double[][] features, double testRatio) {
        int trainSize = (int) (features.length * (1 - testRatio));

        double[][] trainFeatures = new double[trainSize][];
        double[][] testFeatures = new double[features.length - trainSize][];

        System.arraycopy(features, 0, trainFeatures, 0, trainSize);
        System.arraycopy(features, trainSize, testFeatures, 0, features.length - trainSize);

        return new double[][][]{trainFeatures, testFeatures};
    }

    public double[][] splitLabels(double[] labels, double testRatio) {
        int trainSize = (int) (labels.length * (1 - testRatio));

        double[] trainLabels = new double[trainSize];
        double[] testLabels = new double[labels.length - trainSize];

        System.arraycopy(labels, 0, trainLabels, 0, trainSize);
        System.arraycopy(labels, trainSize, testLabels, 0, labels.length - trainSize);

        return new double[][]{trainLabels, testLabels};
    }
}

