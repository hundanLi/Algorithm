package problems.dynamic;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-20 23:44
 **/
public class FindAllConcatenatedWordsInADict {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length < 2) {
            return Collections.emptyList();
        }
        root = new TreeNode();
        for (String word : words) {
            if (word.length() > 0) {
                insert(word);
            }
        }
        List<String> list = new LinkedList<>();
        for (String word : words) {
            if (search(root, word, 0)) {
                list.add(word);
            }
        }
        return list;
    }

    private TreeNode root;

    /**
     * 前缀树
     */
    private class TreeNode {
        String val;
        TreeNode[] children;

        public TreeNode() {
            this.val = null;
            this.children = new TreeNode[26];
        }
    }

    private void insert(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            TreeNode child = cur.children[c];
            if (child == null) {
                child = new TreeNode();
            }
            cur.children[c] = child;
            cur = child;
        }
        cur.val = word;
    }

    private boolean search(TreeNode cur, String word, int index) {
        if (cur == null) {
            return false;
        }
        if (index == word.length()) {
            return cur.val != null && !cur.val.equals(word);
        }
        if (cur.val != null && search(root, word, index)) {
            return true;
        }
        int j = word.charAt(index) - 'a';
        return search(cur.children[j], word, index + 1);
    }

    /**
     * 基于wordBreak，有点暴力的方法
     */
    public List<String> bruteforce(String[] words) {
        if (words == null || words.length < 2) {
            return Collections.emptyList();
        }
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int minLength = -1;
        Set<String> wordDict = new HashSet<>();
        for (String word : words) {
            if (word.length() != 0) {
                minLength = word.length();
                break;
            }
        }
        if (minLength == -1) {
            return Collections.emptyList();
        }
        List<String> list = new LinkedList<>();

        for (String s : words) {
            if (s.length() < (minLength << 1)) {
                if (s.length() > 0) {
                    wordDict.add(s);
                }
                continue;
            }
            if (wordBreak(s, wordDict, minLength, s.length() - minLength)) {
                list.add(s);
            }
            wordDict.add(s);
        }
        return list;
    }

    private boolean wordBreak(String s, Set<String> wordDict, int min, int max) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = min; i <= s.length(); i++) {
            for (int j = i - max; j <= i - min; j++) {
                if (j >= 0 && dp[j]) {
                    if (wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

}
