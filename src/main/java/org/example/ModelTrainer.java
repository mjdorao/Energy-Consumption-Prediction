package org.example;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;

public class ModelTrainer {
    private MultiLayerNetwork model;

    public void initializeModel(MultiLayerConfiguration config) {
        model = new MultiLayerNetwork(config);
        model.init();

    }

    public double[] predict(double[][] input) {
        INDArray inputData = Nd4j.create(input);
        INDArray output = model.output(inputData);
        return output.toDoubleVector();
    }
    public void train(double[][] features, double[] labels) {
        INDArray inputData = Nd4j.create(features);
        INDArray labelData = Nd4j.create(labels);
        DataSet trainingData = new DataSet(inputData, labelData);
        model.fit(trainingData);
    }

    public void evaluate(double[][] features, double[] labels) {
        INDArray inputData = Nd4j.create(features);
        INDArray labelData = Nd4j.create(labels);
        DataSet testData = new DataSet(inputData, labelData);
        double mse = model.score(testData);
        System.out.println("Mean Squared Error: " + mse);
    }

}
