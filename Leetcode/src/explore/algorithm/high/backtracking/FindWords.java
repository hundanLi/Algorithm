package explore.algorithm.high.backtracking;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-26 23:35
 **/
public class FindWords {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new LinkedList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return list;
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> set = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, set, visited, i, j, "");
            }
        }
        list.addAll(set);
        return list;
    }

    private void dfs(char[][] board, Trie trie, Set<String> set, boolean[][] visited, int x, int y, String prefix) {
        if (trie.search(prefix)) {
            set.add(prefix);
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (visited[x][y]) {
            return;
        }

        if (trie.startsWith(prefix)) {
            visited[x][y] = true;
            prefix = prefix + board[x][y];
            dfs(board, trie, set, visited, x + 1, y, prefix);
            dfs(board, trie, set, visited, x - 1, y, prefix);
            dfs(board, trie, set, visited, x, y - 1, prefix);
            dfs(board, trie, set, visited, x, y + 1, prefix);
            visited[x][y] = false;
        }
    }

    class Trie {

        class Node {
            Node[] next;
            boolean isWord;

            Node() {
                isWord = false;
                next = new Node[26];
            }
        }

        Node root;

        /**
         * Initialize your data structure here.
         */
        Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            char[] chars = word.toCharArray();
            int index = 0;
            Node curNode = root;
            while (index < chars.length) {
                int i = chars[index] - 'a';
                if (curNode.next[i] == null) {
                    curNode.next[i] = new Node();
                }
                if (index == chars.length - 1) {
                    curNode.next[i].isWord = true;
                }
                curNode = curNode.next[i];
                index++;
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            char[] chars = word.toCharArray();
            Node curNode = root;
            int index = 0;
            while (index < chars.length) {
                int i = chars[index] - 'a';
                if (curNode.next[i] == null) {
                    return false;
                }
                if (index == chars.length - 1) {
                    if (!curNode.next[i].isWord) {
                        return false;
                    }
                }
                index++;
                curNode = curNode.next[i];
            }
            return true;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return true;
            }
            char[] chars = prefix.toCharArray();
            int index = 0;
            Node curNode = root;
            while (index < chars.length) {
                int i = chars[index] - 'a';
                if (curNode.next[i] == null) {
                    return false;
                }
                index++;
                curNode = curNode.next[i];
            }
            return true;
        }
    }
}
