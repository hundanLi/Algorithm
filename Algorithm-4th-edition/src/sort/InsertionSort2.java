package sort;

import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-10 12:39
 **/
public class InsertionSort2 extends AbstractSort {

    @Override
    public void sort(Comparable[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            // 现在将comparables[0...i-1]中元素比comparables[i]大的右移一个位置
            Comparable temp = comparables[i];
            int j;
            for (j = i; j > 0; j--) {
                if (less(temp, comparables[j - 1])) {
                    comparables[j] = comparables[j - 1];
                } else {
                    break;
                }
            }
            comparables[j] = temp;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Integer[] a = new Integer[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        InsertionSort2.show(a);
        new InsertionSort2().sort(a);
        System.out.println(InsertionSort2.isSorted(a));
        InsertionSort2.show(a);

    }
}
