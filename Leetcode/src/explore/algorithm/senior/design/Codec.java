package explore.algorithm.senior.design;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-10 18:57
 **/
public class Codec {

    public String serialize(TreeNode root) {
        return preOrder(root);
    }

    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        int[] index = new int[]{0};
        return dePreOrder(str, index);
    }

    private String preOrder(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return String.valueOf(root.val) + "," + preOrder(root.left) + "," + preOrder(root.right);
    }

    private TreeNode dePreOrder(String[] data, int[] index) {
        if ("#".equals(data[index[0]])) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index[0]++]));
        root.left = dePreOrder(data, index);
        root.right = dePreOrder(data, index);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);

        System.out.println(codec.serialize(deserialize));
    }
}
