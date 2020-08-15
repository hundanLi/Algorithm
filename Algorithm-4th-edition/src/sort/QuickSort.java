package sort;

import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-12 09:39
 **/
public class QuickSort extends AbstractSort{

    private static Random random = new Random();
    @Override
    public void sort(Comparable[] comps) {
        sort(comps, 0, comps.length - 1);
    }

    private void sort(Comparable[] comps, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = partition(comps, lo, hi);
        sort(comps, lo, mid - 1);
        sort(comps, mid + 1, hi);
    }

    private int partition(Comparable[] comps, int lo, int hi) {
        int idx = lo + random.nextInt(hi - lo + 1);
        Comparable pivot = comps[idx];
        swap(comps, idx, hi);
        int i = lo;
        int j = hi - 1;
        while (true) {
            while (i < hi && less(comps[i], pivot)) {
                i++;
            }
            while (j >= lo && !less(comps[j], pivot)) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(comps, i, j);
        }
        swap(comps, i, hi);
        return i;
    }


    public static void main(String[] args) {
        Integer[] ints = new Integer[20];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(1000);
        }
        System.out.println(QuickSort.isSorted(ints));
        new QuickSort().sort(ints);
        System.out.println(QuickSort.isSorted(ints));
        QuickSort.show(ints);

    }
}
