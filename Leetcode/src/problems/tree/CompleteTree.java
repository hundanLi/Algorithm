package problems.tree;

import explore.datastructure.tree.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-17 13:20
 **/
public class CompleteTree {

    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            int count = count(root);
            int num = number(root, 1);
            return count == num;
        }

        private int count(TreeNode root) {
            return root == null ? 0 : 1 + count(root.left) + count(root.right);
        }

        private int number(TreeNode root, int num) {
            if (root == null) {
                return 0;
            }
            int left = number(root.left, num << 1);
            int right = number(root.right, (num << 1) + 1);
            return Math.max(num, Math.max(left, right));
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int depth = depth(root);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int d = 0;
        TreeNode node;
        int size;
        while (d < depth - 1) {
            size = queue.size();
            // 除了最底层，其余层的节点数为2^d
            if (size != (1 << d)) {
                return false;
            }
            if (d < depth - 2) {
                while (size-- > 0) {
                    node = queue.remove();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            } else {
                // 在倒数第二层检测子节点是否满足最左原则
                boolean flag = false;
                while (size-- > 0) {
                    node = queue.remove();
                    if (node.left == null && node.right != null) {
                        return false;
                    }
                    if (flag) {
                        if (node.left != null) {
                            return false;
                        }
                    } else {
                        if (node.left == null || node.right == null) {
                            flag = true;
                        }
                    }
                }
            }
            d++;
        }
        return true;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    private static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    private static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            boolean ret = new CompleteTree().isCompleteTree(root);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }

}
