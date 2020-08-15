package sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-10 11:13
 **/
public class Example {
    public static void sort(Comparable[] comparables) {
        throw new UnsupportedOperationException("未实现任何排序算法！");
    }

    protected static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected static void swap(Comparable[] comparables, int i, int j) {
        Comparable temp = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = temp;
    }

    protected static void show(Comparable[] comparables) {
        for (Comparable c : comparables) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    protected static boolean isSorted(Comparable[] comparables) {
        for (int i = 0; i < comparables.length - 1; i++) {
            if (!less(comparables[i], comparables[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        sort(args);
        assert isSorted(args);
        show(args);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : pq) {
            System.out.println(i);
        }
//        Random rnd = new Random(20191018);
//        for (int i = 0; i < 5; i++) {
//            System.out.print(rnd.nextInt(100) + " ");
//        }
    }


}
