package explore.algorithm.senior.tree;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-25 20:24
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
