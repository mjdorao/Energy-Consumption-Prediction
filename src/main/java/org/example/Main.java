package org.example;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

            DataLoader loader = new DataLoader();
            List<double[]> loadedData = loader.loadData("data/ENB2012_data.csv");

            DataPreprocessor preprocessor = new DataPreprocessor();
            TrainTestSplitter splitter = new TrainTestSplitter();

            int labelIndex = loadedData.get(0).length - 1; 
            double[][] features = loadedData.stream()
                    .map(row -> java.util.Arrays.copyOf(row, labelIndex))
                    .toArray(double[][]::new);
            double[] labels = loadedData.stream()
                    .mapToDouble(row -> row[labelIndex])
                    .toArray();

            double[][] normalizedFeatures = java.util.Arrays.stream(features)
                    .map(preprocessor::normalizeFeatures)
                    .toArray(double[][]::new);

            double[][][] splitFeatures = splitter.splitFeatures(normalizedFeatures, 0.2);
            double[][] trainFeatures = splitFeatures[0];
            double[][] testFeatures = splitFeatures[1];

            double[][] splitLabels = splitter.splitLabels(labels, 0.2);
            double[] trainLabels = splitLabels[0];
            double[] testLabels = splitLabels[1];

            ModelBuilder builder = new ModelBuilder();
            ModelTrainer trainer = new ModelTrainer();

            MultiLayerConfiguration configuration = builder.buildModel(trainFeatures[0].length, 1);
            trainer.initializeModel(configuration);

            trainer.train(trainFeatures, trainLabels);

            trainer.evaluate(testFeatures, testLabels);
    }
}