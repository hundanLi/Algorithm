package sort;

import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-10 13:43
 **/
public class ShellSort2 extends AbstractSort {
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
                int idx;
                // 将a[i] 插入到 a[i-h], a[i-2h]...中
                // 查找插入位置
                Comparable temp = comparables[i];
                // 现在将comparables[0,h,..,i-h]大于comparables[i]的元素右移
                for (idx = i; idx >= h; idx -= h) {
                    if (less(temp, comparables[idx - h])) {
                        comparables[idx] = comparables[idx - h];
                    } else {
                        break;
                    }
                }
                //插入temp
                comparables[idx] = temp;
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
        System.out.println(ShellSort2.isSorted(ints));
        new ShellSort2().sort(ints);
        System.out.println(ShellSort2.isSorted(ints));
        ShellSort2.show(ints);
    }
}
