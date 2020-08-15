package explore.datastructure.tree.narytree;

import explore.datastructure.tree.Node;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-21 12:03
 **/
public class Traversal {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>(16);
        preorder(root, list);
        return list;
    }

    private void preorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (Node node : root.children) {
            preorder(node, list);
        }
    }


    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>(16);
        postorder(root, list);
        return list;
    }

    private void postorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            postorder(node, list);
        }
        list.add(root.val);
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<Node> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            while (size-- > 0) {
                Node node = queue.remove();
                list.add(node.val);
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            ans.add(list);
        }
        return ans;
    }


}
