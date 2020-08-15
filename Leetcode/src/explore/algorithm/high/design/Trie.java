package explore.algorithm.high.design;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-27 00:13
 **/
public class Trie {

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
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
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
    public boolean search(String word) {
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
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
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
