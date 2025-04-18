package services;

import abstractions.TextIndex;
import contracts.ISearchService;
import contracts.SearchProcessor;
import models.SearchResult;
import models.SearchResultsWrapper;
import models.IndexedColumnRowStorage;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService implements ISearchService {
    private final SearchProcessor processor;
    private final IndexedColumnRowStorage rowStorage;

    public SearchService(SearchProcessor processor, IndexedColumnRowStorage rowStorage) {
        this.processor = processor;
        this.rowStorage = rowStorage;
    }

    public SearchResultsWrapper search(List<String> queries, long initTime) {
        List<SearchResult> results = queries.stream()
                .map(processor::process)
                .collect(Collectors.toList());

        return new SearchResultsWrapper(initTime, results);
    }
}
