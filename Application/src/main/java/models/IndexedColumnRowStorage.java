package models;

import java.util.HashMap;
import java.util.Map;

public class IndexedColumnRowStorage {
    private final Map<Integer, String> valuesByRowId = new HashMap<>();

    public void put(int rowId, String value) {
        valuesByRowId.put(rowId, value);
    }

    public String get(int rowId) {
        return valuesByRowId.get(rowId);
    }
}

