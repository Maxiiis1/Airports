package models;

import java.util.*;

public class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public List<Integer> rowIds = new ArrayList<>();
}
