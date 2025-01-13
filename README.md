AI Energy Consumption Predictor.

This project is a Java-based application designed to preprocess energy consumption data, build and train a neural network model using Deeplearning4j, and evaluate the model's performance on predicting energy usage.

Features:
Data Loading: Reads CSV files containing energy consumption data using OpenCSV.
Data Preprocessing: Normalizes features and splits data into training and testing sets.
Model Creation: Builds a simple neural network with configurable layers using Deeplearning4j.
Model Training: Trains the model on the training dataset.
Model Evaluation: Evaluates the model's performance using Mean Squared Error (MSE) on the test dataset.

Requirements:
Java 17
Maven
Dependencies:
Deeplearning4j
ND4J
DataVec
OpenCSV
Apache Commons Math
SLF4J

Outputs:
Training and evaluation results printed in the console.
Mean Squared Error (MSE) of the predictions on the test data.
