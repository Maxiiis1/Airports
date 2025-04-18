package contracts;
import models.SearchResultsWrapper;

import java.util.List;

public interface ISearchService {
    SearchResultsWrapper search(List<String> queries, long initTime);
}
