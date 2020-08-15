package problems.tree;

import explore.datastructure.tree.TreeNode;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-16 15:03
 **/
public class AllPossibleFBT {
    private Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return Collections.emptyList();
        }
        if (n == 1) {
            return Collections.singletonList(new TreeNode(0));
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        List<TreeNode> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            TreeNode root;
            List<TreeNode> leftList = allPossibleFBT(i);
            List<TreeNode> rightList = allPossibleFBT(n - 1 - i);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        map.put(n, list);
        return list;
    }

}