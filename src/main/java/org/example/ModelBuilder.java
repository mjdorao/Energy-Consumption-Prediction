package org.example;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class ModelBuilder {
    public MultiLayerConfiguration buildModel(int nIn, int nOut) {
        return new NeuralNetConfiguration.Builder()
                .updater(new Adam(0.01))
                .list()
                .layer(0, new DenseLayer.Builder().nIn(nIn).nOut(50)
                        .activation(Activation.RELU).build())
                .layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.MSE)
                        .activation(Activation.IDENTITY).nOut(nOut).build())
                .build();
    }

}
