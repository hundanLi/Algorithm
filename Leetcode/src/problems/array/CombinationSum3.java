package problems.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-27 09:41
 **/
public class CombinationSum3 {
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> list;

    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>(k);
        dfs(k, 1, n);
        return ans;
    }

    private void dfs(int k, int i, int target) {
        if (k < 0 || target < 0) {
            return;
        }
        if (k == 0 && target == 0) {
            ans.add(new ArrayList<>(list));
        }
        for (int j = i; j <= 9; j++) {
            list.add(j);
            dfs(k - 1, j + 1, target - j);
            list.remove(list.size() - 1);
        }

    }
}
