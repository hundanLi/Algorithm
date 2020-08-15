package sort;

import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-13 10:32
 * 适用于包含较多重复元素的三向切分算法
 **/
public class QuickSort3Way extends AbstractSort {

    private static Random random = new Random();

    @Override
    public void sort(Comparable[] comps) {
        sort(comps, 0, comps.length - 1);
    }

    private static void sort(Comparable[] comps, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        // 确定枢纽
        int idx = lo + random.nextInt(hi - lo + 1);
        Comparable pivot = comps[idx];
        swap(comps, lo, idx);

        // 维护三个指针lt, gt, i
        // 在处理过程中，将使得：
        // comps[lo...lt-1]子数组的元素小于pivot；
        // comps[lt...i-1]子数组元素等于pivot；
        // comps[i-1...gt]子数组元素待处理；
        // comps[gt+1...hi]子数组元素大于pivot
        int lt = lo;
        int i = lo;
        int gt = hi;
        while (i <= gt) {
            int cmp = comps[i].compareTo(pivot);
            if (cmp < 0) {
                swap(comps, lt++, i++);
            } else if (cmp > 0) {
                swap(comps, gt--, i);
            } else {
                i++;
            }
        }
        // 现在数组满足下列条件：
        // comps[lo...lt-1]子数组的元素小于pivot；
        // comps[lt...gt]子数组元素等于pivot；
        // comps[gt+1...hi]子数组元素大于pivot

        sort(comps, lo, lt - 1);
        sort(comps, gt + 1, hi);
    }


    public static void main(String[] args) {
        Integer[] ints = new Integer[20];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(1000);
        }
        System.out.println(QuickSort3Way.isSorted(ints));
        new QuickSort3Way().sort(ints);
        System.out.println(QuickSort3Way.isSorted(ints));
        QuickSort3Way.show(ints);
    }
}
