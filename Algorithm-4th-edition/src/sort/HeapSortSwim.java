package sort;

import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-16 11:55
 **/
public class HeapSortSwim extends AbstractSort {

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
     * @param comps 使用上浮和下沉操作的堆排序算法，需要O(N)额外空间
     */
    @Override
    public void sort(Comparable[] comps) {
        int n = comps.length;
        Comparable[] aux = new Comparable[n];
        // 构造堆：逐个插入堆并上浮到合适位置
        for (int i = 0; i < n; i++) {
            aux[i] = comps[i];
            swim(aux, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            comps[i] = aux[0];
            aux[0] = aux[i];
            sink(aux, 0, i - 1);
        }
    }



    public static void main(String[] args) {
        Random random = new Random();
        int n = 30;
        Integer[] ints = new Integer[n];
        for (int i = 0; i < n; i++) {
            ints[i] = random.nextInt(100);
        }
        HeapSort.show(ints);
        System.out.println(HeapSortSwim.isSorted(ints));
        new HeapSortSwim().sort(ints);
        System.out.println(HeapSortSwim.isSorted(ints));
        HeapSortSwim.show(ints);
    }
}
