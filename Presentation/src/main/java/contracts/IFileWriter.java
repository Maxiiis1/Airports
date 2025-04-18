package contracts;
import models.SearchResult;
import models.SearchResultsWrapper;

import java.util.List;


public interface IFileWriter {
    void write(SearchResultsWrapper wrapper, String filePath);
}