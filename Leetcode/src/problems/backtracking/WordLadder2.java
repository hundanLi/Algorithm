package problems.backtracking;


import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-06 17:00
 **/
public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
            return Collections.emptyList();
        }
        return bfs(beginWord, endWord, wordList);
    }

    private List<List<String>> bfs(String begin, String end, List<String> wordList) {
        List<List<String>> ans = new LinkedList<>();
        boolean found = false;
        boolean[] visited = new boolean[wordList.size()];
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(begin);
        queue.offer(path);
        while (!found && !queue.isEmpty()) {
            int size = queue.size();
            String cur;
            String next;
            List<String> p;
            Set<Integer> visitedIdx = new HashSet<>();
            while (size-- > 0) {
                // 路径列表
                p = queue.remove();
                // 当前路径末尾单词
                cur = p.get(p.size() - 1);
                for (int i = 0; i < wordList.size(); i++) {
                    next = wordList.get(i);
                    if (visited[i] || next.equals(begin)) {
                        continue;
                    }
                    if (isLadder(cur, next)) {
                        visitedIdx.add(i);
                        p.add(next);
                        if (next.equals(end)) {
                            // 到达终点
                            found = true;
                            ans.add(new ArrayList<>(p));
                        } else {
                            queue.offer(new ArrayList<>(p));
                        }
                        p.remove(p.size() - 1);

                    }
                }
            }
            for (int idx : visitedIdx) {
                visited[idx] = true;
            }
        }
        return ans;
    }

    private boolean isLadder(String word1, String word2) {
        int n = word1.length();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (!flag) {
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String begin = "red";
        String end = "tax";
        String[] words = {"ted","tex","red","tax","tad","den","rex","pee"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        System.out.println(new WordLadder2().findLadders(begin, end, wordList));
    }
}
