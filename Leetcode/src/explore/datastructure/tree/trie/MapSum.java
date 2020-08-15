package explore.datastructure.tree.trie;

import java.util.HashMap;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-21 15:35
 **/
public class MapSum {
    static class TrieNode {
        int value;
        HashMap<Character, TrieNode> children;

        TrieNode(int value) {
            this.value = value;
            this.children = new HashMap<>();
        }

        TrieNode() {
            this(0);
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        if (key == null) {
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode(0));
            }
            cur = cur.children.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        if (prefix == null) {
            return 0;
        }
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.children.containsKey(c)) {
                return 0;
            }
            cur = cur.children.get(c);
        }
        return preorder(cur);
    }

    private int preorder(TrieNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.value;
        for (TrieNode node : root.children.values()) {
            sum += preorder(node);
        }
        return sum;
    }


}
