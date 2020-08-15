package explore.datastructure.tree.bst;


import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-20 09:34
 **/
public class KthLargest {
    static class Node {
        int val;
        int cnt;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }

    private Node bst;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        bst = construct(nums);
    }

    public int add(int val) {
        bst = insert(bst, val);
        return findKth(bst, k);
    }

    private int findKth(Node root, int k) {
        int lc = count(root.left);
        int rc = count(root.right);
        int cc = root.cnt - lc - rc;
        // 第kth结点在右子树
        if (k <= rc) {
            return findKth(root.right, k);
        }
        // 第kth结点在左子树
        if (k > cc + rc) {
            return findKth(root.left, k - (cc + rc));
        }
        // 第kth结点在根节点
        return root.val;
    }

    private int count(Node root) {
        if (root == null) {
            return 0;
        }
        return root.cnt;
    }

    private Node construct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Node root = new Node(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            root = insert(root, nums[i]);
        }
        return root;
    }

    private Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val, 1);
            return root;
        }
        Node cur = root;
        while (true) {
            if (cur.val > val) {
                cur.cnt++;
                if (cur.left == null) {
                    cur.left = new Node(val, 1);
                    break;
                } else {
                    cur = cur.left;
                }
            } else if (cur.val < val) {
                cur.cnt++;
                if (cur.right == null) {
                    cur.right = new Node(val, 1);
                    break;
                } else {
                    cur = cur.right;
                }
            } else {
                cur.cnt++;
                break;
            }
        }
        return root;
    }


    static class KthLargest1 {
        private int k;
        private PriorityQueue<Integer> pq;

        public KthLargest1(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int n : nums) {
                add(n);
            }
        }

        public int add(int val) {
            if (pq.size() < k) {
                pq.offer(val);
            } else {
                if (pq.element() < val) {
                    pq.remove();
                    pq.offer(val);
                }
            }
            return pq.element();
        }
    }

}
