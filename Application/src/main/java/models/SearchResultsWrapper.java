package models;

import java.util.List;

public class SearchResultsWrapper {
    private long initTime;
    private List<SearchResult> result;

    public SearchResultsWrapper(long initTime, List<SearchResult> result) {
        this.initTime = initTime;
        this.result = result;
    }

    public long getInitTime() {
        return initTime;
    }

    public List<SearchResult> getResult() {
        return result;
    }
}
