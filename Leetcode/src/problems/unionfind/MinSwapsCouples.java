package problems.unionfind;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-11 09:53
 **/
public class MinSwapsCouples {
    static class UnionFind {

        int[] parent;
        int count;

        UnionFind(int size) {
            parent = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[px] = py;
                count--;
            }
        }
    }

    public int minSwapsCouples(int[] nums) {
        int n = nums.length / 2;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int a = nums[2 * i];
            int b = nums[2 * i + 1];
            uf.union(a / 2, b / 2);
        }
        return n - uf.count;
    }

}
