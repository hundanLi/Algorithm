package mock.month1909;


import datastructure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-05 09:22
 **/
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        return generate(1, n);
    }

    private List<TreeNode> generate(int begin, int end) {
        List<TreeNode> trees = new LinkedList<>();
        if (begin > end) {
            trees.add(null);
            return trees;
        }
        // 选择根节点
        for (int i = begin; i <= end ; i++) {
            List<TreeNode> leftTrees = generate(begin, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, end);

            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    trees.add(root);
                }
            }

        }
        return trees;
    }
}
