package mock.month1909;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-28 22:34
 **/
public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        return bfs(beginWord, endWord, wordList);
    }

    private int bfs(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int cnt = 1;
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.remove();
                String next;
                for (int i = 0; i < wordList.size(); i++) {
                    next = wordList.get(i);
                    if (visited[i] || next.equals(beginWord)) {
                        continue;
                    }
                    if (isLadder(word, next)) {
                        if (next.equals(endWord)) {
                            return cnt;
                        }
                        visited[i] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return 0;

    }

    private boolean isLadder(String word1, String word2) {
        boolean hasDiff = false;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (!hasDiff) {
                    hasDiff = true;
                } else {
                    return false;
                }
            }
        }
        return hasDiff;
    }

    public static void main(String[] args) {
        String bw = "qa";
        String ew = "sq";
        String[] wordList = {"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
        List<String> list = new ArrayList<>();
        Collections.addAll(list, wordList);
        System.out.println(new LadderLength().ladderLength(bw, ew, list));
    }
}
