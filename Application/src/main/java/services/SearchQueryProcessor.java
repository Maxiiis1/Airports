package services;

import abstractions.TextIndex;
import contracts.SearchProcessor;
import models.SearchResult;

import java.util.List;

public class SearchQueryProcessor implements SearchProcessor {
    private final TextIndex index;

    public SearchQueryProcessor(TextIndex index) {
        this.index = index;
    }

    public SearchResult process(String query) {
        long start = System.nanoTime();
        List<Integer> ids = index.findByPrefix(query);
        long end = System.nanoTime();

        SearchResult result = new SearchResult();
        result.setSearch(query);
        result.setResult(ids);
        result.setTime((end - start) / 1_000_000);

        return result;
    }
}
