package indexes;

import abstractions.TextIndex;
import models.TrieNode;

import java.util.*;


public class TrieAirportIndex implements TextIndex {
    private final TrieNode root = new TrieNode();

    @Override
    public void add(String value, int rowId) {
        TrieNode node = root;
        for (char c : value.toLowerCase().toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
            node.rowIds.add(rowId);
        }
    }

    @Override
    public List<Integer> findByPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toLowerCase().toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return Collections.emptyList();
            }
        }
        return node.rowIds;
    }
}

