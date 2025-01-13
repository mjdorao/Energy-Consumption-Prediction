package org.example;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public List<double[]> loadData(String filePath) throws IOException {
        List<double[]> data = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;

            reader.readNext();

            while ((line = reader.readNext()) != null) {
                double[] values = new double[line.length];
                for (int i = 0; i < line.length; i++) {
                    values[i] = Double.parseDouble(line[i]);
                }
                data.add(values);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
