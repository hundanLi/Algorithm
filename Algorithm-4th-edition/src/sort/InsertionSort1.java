package sort;

import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-10 12:26
 **/
public class InsertionSort1 extends AbstractSort {

    @Override
    public void sort(Comparable[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(comparables[j], comparables[j - 1])) {
                    swap(comparables, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Integer[] a = new Integer[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        InsertionSort1.show(a);
        new InsertionSort1().sort(a);
        System.out.println(InsertionSort1.isSorted(a));
        InsertionSort1.show(a);

    }

}
