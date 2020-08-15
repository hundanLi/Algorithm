package sort;

import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-11 09:51
 **/
public class MergeSort extends AbstractSort{

    /**
     * 辅助数组
     */
    private Comparable[] aux;
    @Override
    public void sort(Comparable[] comparables) {
        aux = new Comparable[comparables.length];
        sort(comparables, 0, comparables.length - 1);
    }

    private void sort(Comparable[] comparables, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(comparables, lo, mid);
        sort(comparables, mid + 1, hi);
        merge(comparables, lo, mid, hi);
    }

    private void merge(Comparable[] comparables, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = comparables[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            // 左数组用尽
            if (i > mid) {
                comparables[k] = aux[j++];
            } else if (j > hi) {
                // 右数组用尽
                comparables[k] = aux[i++];
            } else {
                if (less(aux[j], aux[i])) {
                    comparables[k] = aux[j++];
                } else {
                    comparables[k] = aux[i++];
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Integer[] ints = new Integer[30];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(100);
        }
        System.out.println(MergeSort.isSorted(ints));
        new MergeSort().sort(ints);
        System.out.println(MergeSort.isSorted(ints));
        MergeSort.show(ints);

    }
}
