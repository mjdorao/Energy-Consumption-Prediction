package org.example;

public class DataPreprocessor {
    public double[] normalizeFeatures(double[] data) {
       double min = Double.MAX_VALUE;
       double max = Double.MIN_VALUE;
       for (double d : data) {
           if (d < min) min = d;
           if (d > max) max = d;
       }
       double[] normalizedData = new double[data.length];
       for (int i = 0; i < data.length; i++) {
           normalizedData[i] = (data[i] - min) / (max - min);
       }
       return normalizedData;
   }

}