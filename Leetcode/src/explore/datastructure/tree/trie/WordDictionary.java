package explore.datastructure.tree.trie;

import java.util.Objects;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-21 17:19
 **/
public class WordDictionary {

    private Trie trie;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        trie = new Trie();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        trie.insert(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return trie.search(word);
    }


    static class Trie {

        static class TrieNode {
            boolean word;
            TrieNode[] children;

            TrieNode(boolean word) {
                this.word = word;
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
        Trie() {
            this.root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || Objects.equals(word.trim(), "")) {
                return;
            }
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new TrieNode(false);
                }
                cur = cur.children[c];
            }
            cur.word = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return search(root, word, 0);
        }


        private boolean search(TrieNode root, String word, int index) {
            if (word == null || Objects.equals(word.trim(), "")) {
                return false;
            }

            TrieNode cur = root;
            for (int i = index; i < word.length(); i++) {
                if (word.charAt(i) == '.') {
                    for (TrieNode node : cur.children) {
                        if (node != null) {
                            if (search(node, word, i + 1)) {
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    int c = word.charAt(i) - 'a';
                    if (cur.children[c] == null) {
                        return false;
                    }
                    cur = cur.children[c];
                }
            }
            return cur.word;
        }

    }

    public static void main(String[] args) {
        String[] words = {"bad", "dad", "mad"};
        WordDictionary dictionary = new WordDictionary();
        for (String word : words) {
            dictionary.addWord(word);
        }

        String[] keys = {"pad", "bad", ".ad", "b.."};
        for (String key : keys) {
            System.out.println(dictionary.search(key));
        }
    }
}
