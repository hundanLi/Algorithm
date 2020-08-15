package explore.datastructure.hashtable;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-10 09:20
 **/
public class DuplicateSubtrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private Map<String, Integer> subtrees = new HashMap<>();
    private List<TreeNode> ans = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return ans;
    }

    private String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String subtree = String.valueOf(root.val) + "," +
                serialize(root.left) + "," +
                serialize(root.right);
        subtrees.put(subtree, subtrees.getOrDefault(subtree, 0) + 1);

        if (subtrees.get(subtree) == 2) {
            ans.add(root);
        }
        return subtree;
    }
}
