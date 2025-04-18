package contracts;

import models.SearchResult;

public interface SearchProcessor {
    SearchResult process(String query);
    }
