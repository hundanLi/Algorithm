package explore.datastructure.tree.binarytree;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-17 10:11
 **/
public class Connect2 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = root;
        Node cur;
        while (pre != null) {
            cur = pre;
            // 寻找cur这一层中的子节点的next
            while (cur != null) {
                // 寻找左子节点的next
                if (cur.left != null) {
                    if (cur.right != null) {
                        cur.left.next = cur.right;
                    } else {
                        // 将cur.left右边的第一个结点作为next
                        cur.left.next = findNext(cur.next);
                    }
                }
                // 寻找右子节点的next
                if (cur.right != null) {
                    // 将cur.right右边的第一个结点作为next
                    cur.right.next = findNext(cur.next);
                }
                cur = cur.next;
            }
            // 更新pre为下一层中的最左端结点
            pre = findNext(pre);
        }
        return root;
    }

    /**
     * 寻找next结点
     */
    private static Node findNext(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.val = 3;
        root.left = new Node();
        root.left.val = 9;
        root.right = new Node();
        root.right.val = 20;
        root.right.left = new Node();
        root.right.left.val = 15;
        root.right.right = new Node();
        root.right.right.val = 7;
        connect(root);
    }


    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            //层数
            Node line = new Node();
            //于遍历第i行节点的cur指针，添加第i+1行next的prev指针
            Node cur, prev = line;

            for (cur = root; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    prev.next = cur.left;
                    prev = prev.next;
                }
                if (cur.right != null) {
                    prev.next = cur.right;
                    prev = prev.next;
                }
            }
            connect(line.next);

            return root;
        }
    }
}
