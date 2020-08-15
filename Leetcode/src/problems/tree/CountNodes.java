package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-24 13:19
 **/
public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    class Solution {
        public int countNodes(TreeNode root) {
            if(root == null){
                return 0;
            }
            int left = countLevel(root.left);
            int right = countLevel(root.right);
            if(left == right){
                return countNodes(root.right) + (1<<left);
            }else{
                return countNodes(root.left) + (1<<right);
            }
        }
        private int countLevel(TreeNode root){
            int level = 0;
            while(root != null){
                level++;
                root = root.left;
            }
            return level;
        }
    }

}
