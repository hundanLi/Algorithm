package mock.month1909;

import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-29 16:31
 **/
public class Bonus {

    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }
        for (int[] ship : leadership) {
            Node p = nodes[ship[0]];
            Node c = nodes[ship[1]];
            c.parent = p;
            if (p.child == null) {
                p.child = new LinkedList<>();
            }
            p.child.add(c);
        }
        int mod = 1000_000_007;
        List<Integer> query = new LinkedList<>();
        for (int[] operation : operations) {
            // 操作成员对象
            Node node = nodes[operation[1]];
            // 操作类型
            int type = operation[0];
            // coin数量
            int coin;
            if (type == 1) {
                coin = operation[2];
                addCoinOnce(node, coin);
            } else if (type == 2) {
                coin = operation[2];
                int coinMore = addCoinMore(node, coin);
                addCoinOnce(node.parent, coinMore);
            } else {
                query.add(node.val % mod);
            }
        }
        int[] ans = new int[query.size()];
        for (int i = 0; i < query.size(); i++) {
            ans[i] = query.get(i);
        }
        return ans;
    }

    private void addCoinOnce(Node node, int coin) {
        while (node != null) {
            node.val += coin;
            node = node.parent;
        }
    }

    private int addCoinMore(Node node, int coin) {
        if (node == null) {
            return 0;
        }
        int n = coin;
        if (node.child != null) {
            for (Node ch : node.child) {
                n += addCoinMore(ch, coin);
            }
        }
        node.val += n;
        return n;
    }

    private static class Node {
        int val;
        Node parent;
        List<Node> child;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
