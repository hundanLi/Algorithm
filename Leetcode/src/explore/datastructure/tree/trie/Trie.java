package explore.datastructure.tree.trie;

import java.util.Objects;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-21 15:17
 **/
public class Trie {

    static class TrieNode {
        boolean isWord;
        TrieNode[] children;

        TrieNode(boolean isWord) {
            this.isWord = isWord;
            this.children = new TrieNode[26];
        }

        TrieNode() {
            this(false);
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || Objects.equals(word.trim(), "")) {
            return;
        }
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(false);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || Objects.equals(word.trim(), "")) {
            return false;
        }
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || Objects.equals(prefix.trim(), "")) {
            return false;
        }
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }

}
