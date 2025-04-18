package ru.fink;

import contracts.*;
import indexes.TrieAirportIndex;
import models.IndexedColumnRowStorage;
import models.SearchResultsWrapper;
import adapters.CSVFileReader;
import adapters.JSONFileWriter;
import services.IndexingLineProcessor;
import services.SearchQueryProcessor;
import services.SearchService;
import abstractions.TextIndex;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        long programStart = System.currentTimeMillis();

        try {
            ArgsParse parser = new ArgsParse(args);
            String dataFilePath = parser.getRequiredArg("--data");
            int columnId = Integer.parseInt(parser.getRequiredArg("--indexed-column-id")) - 1;
            String inputFilePath = parser.getRequiredArg("--input-file");
            String outputFilePath = parser.getRequiredArg("--output-file");

            TextIndex index = new TrieAirportIndex();
            IndexedColumnRowStorage rowStorage = new IndexedColumnRowStorage();
            IFileReader reader = new CSVFileReader();
            LineProcessor processor = new IndexingLineProcessor(columnId, index, rowStorage);

            reader.read(dataFilePath, processor);

            long initTime = System.currentTimeMillis() - programStart;

            List<String> queries;
            try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
                queries = br.lines().collect(Collectors.toList());
            }

            SearchProcessor queryProcessor = new SearchQueryProcessor(index);
            ISearchService searchService = new SearchService(queryProcessor, rowStorage);
            SearchResultsWrapper wrapper = searchService.search(queries, initTime);

            IFileWriter fileWriter = new JSONFileWriter();
            fileWriter.write(wrapper, outputFilePath);

        } catch (Exception e) {
            System.err.println("Ошибка при выполнении программы: " + e.getMessage());
            e.printStackTrace();
        }
    }
}