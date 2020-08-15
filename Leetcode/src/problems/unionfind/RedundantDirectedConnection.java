package problems.unionfind;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-09 10:03
 *
 * 有向图带来了一个变化
 * 就是形成的环有可能是环上每个边remove都可以形成valid tree,
 * 也可能环上有一个奇葩node有两个爹。
 * 因而
 * 1：如果没有这种奇葩node，那同志们就按照上一题来做就好了，一模一样
 * 2：如果出现了这种奇葩node，那结果一定在这个奇葩node跟他爹们的两条边之中
 * 再细分为两种情况：当这个奇葩node出现的时候，他和他两个爹形成的两条边能构成两种情况
 * 2.1. 两个边都在这个环上，根据题意选在数组中后出现的边。
 * 2.2. 只有一个边在这个环上，那就选在环上的这条边
 **/
public class RedundantDirectedConnection {

    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) {
                return false;
            }
            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else {
                parent[pb] = pa;
                if (rank[pa] == rank[pb]) {
                    rank[pa]++;
                }
            }
            return true;
        }

        int find(int a) {
            while (a != parent[a]) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }
    }

    private final int MAX_EDGE_NUM = 1000;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }
        int[] c1 = new int[2];
        int[] c2 = new int[2];

        int[] parent = new int[edges.length + 1];
        for (int[] edge : edges) {
            if (parent[edge[1]] != 0) {
                c1 = new int[]{parent[edge[1]], edge[1]};
                c2 = new int[]{edge[0], edge[1]};
                break;
            }
            parent[edge[1]] = edge[0];
        }
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] e : edges) {
            if ((e[0] == c1[0] && e[1] == c1[1]) || (e[0] == c2[0] && e[1] == c2[1])) {
                continue;
            }
            if (!uf.union(e[0], e[1])) {
                return e;
            }
        }
        if (!uf.union(c1[0], c1[1])) {
            return c1;
        }
        return c2;
    }

}
