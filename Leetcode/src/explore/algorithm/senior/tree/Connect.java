package explore.algorithm.senior.tree;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-25 20:33
 **/
public class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = root;
        Node cur;
        while (pre.left != null) {
            cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;
    }


}
