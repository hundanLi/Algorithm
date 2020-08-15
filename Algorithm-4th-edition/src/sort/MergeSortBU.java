package sort;

import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-11 10:14
 **/
public class MergeSortBU extends AbstractSort {
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] comps) {
        int n = comps.length;
        aux = new Comparable[n];
        // size表示子数组大小
        for (int size = 1; size < n; size = size + size) {
            // lo表示子数组起始索引
            for (int lo = 0; lo < n - size; lo += size + size) {
                merge(comps, lo, lo + size - 1, Math.min(lo + size + size - 1, n - 1));
            }
        }
    }

    private void merge(Comparable[] comps, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = comps[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            // 左数组用尽
            if (i > mid) {
                comps[k] = aux[j++];
            } else if (j > hi) {
                // 右数组用尽
                comps[k] = aux[i++];
            } else {
                if (less(aux[j], aux[i])) {
                    comps[k] = aux[j++];
                } else {
                    comps[k] = aux[i++];
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Integer[] ints = new Integer[20];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(100);
        }
        System.out.println(MergeSortBU.isSorted(ints));
        new MergeSortBU().sort(ints);
        System.out.println(MergeSortBU.isSorted(ints));
        MergeSortBU.show(ints);
    }


}
