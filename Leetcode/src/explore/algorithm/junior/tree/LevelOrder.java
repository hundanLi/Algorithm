package explore.algorithm.junior.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-19 13:32
 **/
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<Queue<TreeNode>> queues = new LinkedList<>();
        Queue<TreeNode> firstLevel = new LinkedList<>();
        firstLevel.add(root);
        queues.add(firstLevel);

        while (!queues.isEmpty()) {
            List<Integer> currentList = new ArrayList<>();
            Queue<TreeNode> currentLevel = queues.poll();
            Queue<TreeNode> nextLevel = new LinkedList<>();
            while (!currentLevel.isEmpty()) {
                TreeNode node = currentLevel.poll();
                currentList.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            lists.add(currentList);
            if (!nextLevel.isEmpty()) {
                queues.add(nextLevel);
            }
        }
        return lists;
    }
}
