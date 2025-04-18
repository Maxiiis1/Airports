package adapters;

import com.fasterxml.jackson.databind.ObjectMapper;
import contracts.IFileWriter;
import models.SearchResult;
import models.SearchResultsWrapper;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JSONFileWriter implements IFileWriter {

    @Override
    public void write(SearchResultsWrapper wrapper, String filePath){
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(filePath), StandardCharsets.UTF_8)) {

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(writer, wrapper);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при записи JSON: " + e.getMessage(), e);
        }
    }
}
