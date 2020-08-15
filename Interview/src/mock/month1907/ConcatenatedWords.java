package mock.month1907;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-19 09:52
 * 前缀树
 **/
public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> ans = new ArrayList<>(words.length);
        for (String word : words) {
            if (trie.search(word, 0)) {
                ans.add(word);
            }
        }

        return ans;
    }

    /**
     * 使用字典树
     */
    private static class Trie {
        private TreeNode root;

        private static class TreeNode {
            String val;
            TreeNode[] children;

            public TreeNode() {
                this.val = null;
                this.children = new TreeNode[26];
            }
        }

        Trie() {
            this.root = new TreeNode();
        }

        private void insert(String word) {
            TreeNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new TreeNode();
                }
                cur = cur.children[c];
            }
            cur.val = word;
        }

        private boolean search(String word, int idx) {
            TreeNode cur = root;
            for (int i = idx; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                cur = cur.children[c];
                if (cur == null) {
                    return false;
                }
                if (i < word.length() - 1) {
                    if (cur.val != null && !word.equals(cur.val)) {
                        if (search(word, i + 1)) {
                            return true;
                        }
                    }
                }
            }
            return cur.val != null && !word.equals(cur.val);
        }
    }


    private Set<String> dict = new HashSet<>();

    /**
     * 深度优先搜索
     */
    public List<String> findAllConcatenatedWordsInADict2(String[] words) {
        dict.addAll(Arrays.asList(words));
        List<String> ans = new ArrayList<>(words.length);
        for (String word : words) {
            if (dfs(word, 0, 0)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean dfs(String word, int idx, int cnt) {
        if (idx == word.length()) {
            return cnt > 1;
        }
        for (int i = idx; i < word.length(); i++) {
            if (dict.contains(word.substring(idx, i + 1))) {
                if (dfs(word, i + 1, cnt + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
