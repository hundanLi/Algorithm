package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-14 12:08
 **/
public class Codec {
    /** Encodes a tree to a single string. */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        doSerialize(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void doSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        doSerialize(root.left, sb);
        doSerialize(root.right, sb);
    }

    /** Decodes your encoded data to tree. */
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return doDeserialize(nodes, new int[]{0});
    }

    private TreeNode doDeserialize(String[] nodes, int[] idx) {
        if ("#".equals(nodes[idx[0]])) {
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx[0]++]));
        root.left = doDeserialize(nodes, idx);
        root.right = doDeserialize(nodes, idx);
        return root;
    }
}
