package sort;

import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-10 13:43
 **/
public class ShellSort1 extends AbstractSort {
    @Override
    public void sort(Comparable[] comparables) {
        int len = comparables.length;
        int h = 1;
        while (h < len / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            // 将数组变得h有序
            for (int i = h; i < comparables.length; i++) {
                // 将a[i] 插入到 a[i-h], a[i-2h]...中
                for (int j = i; j >= h; j -= h) {
                    if (less(comparables[j], comparables[j - h])) {
                        swap(comparables, j, j - h);
                    }
                }
            }
            h /= 3;
        }
    }



    public static void main(String[] args) {
        Random random = new Random();
        Integer[] ints = new Integer[100];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(1000);
        }
        System.out.println(ShellSort1.isSorted(ints));
        new ShellSort1().sort(ints);
        System.out.println(ShellSort1.isSorted(ints));
    }
}
