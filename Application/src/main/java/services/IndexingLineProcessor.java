package services;

import contracts.LineProcessor;
import abstractions.TextIndex;
import models.IndexedColumnRowStorage;

public class IndexingLineProcessor implements LineProcessor {
    private final int columnIndex;
    private final TextIndex textIndex;
    private final IndexedColumnRowStorage rowStorage;

    public IndexingLineProcessor(int columnIndex, TextIndex textIndex, IndexedColumnRowStorage rowStorage) {
        this.columnIndex = columnIndex;
        this.textIndex = textIndex;
        this.rowStorage = rowStorage;
    }

    @Override
    public void processLine(String[] columns, int lineNumber) {
        if (columnIndex >= columns.length) {
            return;
        }

        String value = columns[columnIndex];
        if (value != null && !value.isBlank()) {
            textIndex.add(value, lineNumber);
            rowStorage.put(lineNumber, value);
        }
    }
}
