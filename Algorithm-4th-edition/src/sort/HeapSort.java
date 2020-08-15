package sort;


import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-16 11:55
 **/
public class HeapSort extends AbstractSort {

    static class MaxPQ<Key extends Comparable<Key>> {
        private Key[] pq;   //基于堆的完全二叉树
        private int n = 0;  //堆元素个数：pq[1...n]，pq[0]不使用

        public MaxPQ(int maxN) {
            pq = (Key[]) new Comparable[maxN + 1];
        }

        public int size() {
            return n;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public void insert(Key k) {
            pq[n++] = k;
            swim(n);
        }

        public Key delMax() {
            Key max = pq[1];
            swap(1, n--);
            pq[n + 1] = null;
            sink(1);
            return max;
        }

        /**
         * @param i 从索引i处开始执行上浮操作
         */
        private void swim(int i) {
            // 父节点小于子节点，交换
            while (i > 1 && less(i / 2, i)) {
                swap(i / 2, i);
                i /= 2;
            }
        }

        /**
         * @param k 从索引k出开始执行下沉操作
         */
        private void sink(int k) {
            int j = 2 * k;
            while (j <= n) {
                if (j < n && less(j, j + 1)) {
                    j++;
                }
                // 父节点小于较大子节点，交换
                if (less(k, j)) {
                    swap(k, j);
                    k = j;
                } else {
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            Key t = pq[i];
            pq[i] = pq[j];
            pq[j] = t;
        }

        private boolean less(int i, int j) {
            return pq[i].compareTo(pq[j]) < 0;
        }


    }

    /**
     * @param i 从索引i处开始执行上浮操作
     */
    private static void swim(Comparable[] comps, int i) {
        int j = (i - 1) >> 1;
        // 父节点小于子节点，交换
        while (i > 0 && less(comps[j], comps[i])) {
            swap(comps, j, i);
            i = j;
            j = (i - 1) >> 1;
        }
    }

    /**
     * @param k 从索引k出开始执行下沉操作
     * @param n 参与操作的最大索引n
     */
    private static void sink(Comparable[] comps, int k, int n) {
        int j = (k << 1) + 1;
        while (j <= n) {
            if (j < n && less(comps[j], comps[j + 1])) {
                j++;
            }
            // 父节点小于较大子节点，交换
            if (less(comps[k], comps[j])) {
                swap(comps, k, j);
                k = j;
                j = (k << 1) + 1;
            } else {
                break;
            }
        }
    }


    /**
     * @param comps 只使用下沉操作的堆排序算法
     */
    @Override
    public void sort(Comparable[] comps) {
        int n = comps.length;
        for (int k = n / 2; k >= 0; k--) {
            sink(comps, k, n - 1);
        }
        n--;
        while (n > 0) {
            swap(comps, 0, n--);
            sink(comps, 0, n);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Integer[] ints = new Integer[30];
        for (int i = 0; i < 30; i++) {
            ints[i] = random.nextInt(100);
        }
        System.out.println(HeapSort.isSorted(ints));
        new HeapSort().sort(ints);
        System.out.println(HeapSort.isSorted(ints));
        HeapSort.show(ints);
    }
}
