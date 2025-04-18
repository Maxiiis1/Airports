package abstractions;

import java.util.List;

public interface TextIndex {
    void add(String value, int rowId);
    List<Integer> findByPrefix(String prefix);
}