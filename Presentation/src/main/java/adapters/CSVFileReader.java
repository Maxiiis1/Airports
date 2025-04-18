package adapters;

import contracts.IFileReader;
import contracts.LineProcessor;
import java.io.FileReader;

import java.io.BufferedReader;
import java.io.IOException;

public class CSVFileReader implements IFileReader {

    @Override
    public void read(String filePath, LineProcessor processor) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowId = 0;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",", -1);
                processor.processLine(columns, rowId);
                rowId++;
            }

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла: " + e.getMessage(), e);
        }
    }
}
