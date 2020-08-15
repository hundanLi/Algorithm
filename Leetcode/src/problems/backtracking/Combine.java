package problems.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-21 10:02
 **/
public class Combine {

    private List<List<Integer>> lists = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || n < k) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>(k);
        dfs(n, 1, k, list);
        return lists;
    }

    private void dfs(int n, int s, int k, List<Integer> list) {
        if (k == list.size()) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = s; i <= n; i++) {
            list.add(i);
            dfs(n, i + 1, k, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }
}
