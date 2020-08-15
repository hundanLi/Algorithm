package explore.datastructure.tree.trie;


import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-22 09:55
 **/
public class PalindromePairs {
    static class TrieNode {
        Set<Integer> palindromeIndices;
        int index;
        TrieNode[] children;

        TrieNode() {
            palindromeIndices = new HashSet<>();
            index = -1;
            children = new TrieNode[26];
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word, int index) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                // word[0->i]是回文串，为后面 word[length->i] + word 组成回文对使用
                if (palindrome(word, 0, i)) {
                    cur.palindromeIndices.add(index);
                }
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            cur.index = index;
        }


        void searchPalindrome(List<List<Integer>> ans, String word, int index) {

            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                // word + cur.word 组成回文串，word末尾有余且符合回文规则
                if (cur.index >= 0 && palindrome(word, i, word.length() - 1)) {
                    ans.add(Arrays.asList(index, cur.index));
                }
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    return;
                }
                cur = cur.children[c];
            }
            // word + cur.word 组成回文串，cur.word开头部分有余且符合回文规则
            for (int idx : cur.palindromeIndices) {
                ans.add(Arrays.asList(index, idx));
            }

            // word + cur.word 组成回文串，且两串长度恰好相等
            if (cur.index >= 0 && index != cur.index) {
                ans.add(Arrays.asList(index, cur.index));
            }
        }

    }

    private static boolean palindrome(String word, int start, int end) {
        int i = start;
        int j = end;
        if (i > j) {
            return false;
        }
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length <= 1) {
            return Collections.emptyList();
        }
        Trie trie = new Trie();
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            trie.searchPalindrome(ans, words[i], i);
        }
        return ans;
    }


    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll", ""};
        List<List<Integer>> pairs = palindromePairs(words);
        for (List<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }
}
