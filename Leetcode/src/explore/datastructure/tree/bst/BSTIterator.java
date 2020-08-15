package explore.datastructure.tree.bst;

import explore.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-17 15:13
 **/
public class BSTIterator {

    class BSTIterator1 {
        private List<Integer> values;
        private int index;
        public BSTIterator1(TreeNode root) {
            values = new ArrayList<>();
            inorder(root);
            index = 0;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return values.get(index++);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return index < values.size();
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            values.add(root.val);
            inorder(root.right);
        }
    }


    class BSTIterator2 {
        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator2(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) {
                TreeNode cur = node.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
            return node.val;
        }

        public boolean hasNext(){
            return !stack.isEmpty();
        }
    }
}
