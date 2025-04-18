package models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResult {
    private String search;
    private List<Integer> result;
    private long time;
}
