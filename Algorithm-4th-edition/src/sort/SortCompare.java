package sort;

import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-10 13:07
 **/
public class SortCompare {
    public static final int SELECTION_SORT = 0;
    public static final int INSERTION_SORT_1 = 11;
    public static final int INSERTION_SORT_2 = 12;
    public static final int SHELL_SORT_1 = 21;
    public static final int SHELL_SORT_2 = 22;
    public static final int MERGE_SORT = 3;
    public static final int MERGE_SORT_BU = 32;
    public static final int QUICK_SORT = 4;
    public static final int QUICK_SORT_3WAY = 41;
    public static final int HEAP_SORT = 5;
    public static final int HEAP_SORT_SWIM = 51;

    public static long time(Comparable[] comps, int alg) {
        long start = System.currentTimeMillis();
        switch (alg) {
            case SELECTION_SORT:
                new SelectionSort().sort(comps);
                break;
            case INSERTION_SORT_1:
                new InsertionSort1().sort(comps);
                break;
            case INSERTION_SORT_2:
                new InsertionSort2().sort(comps);
                break;
            case SHELL_SORT_1:
                new ShellSort1().sort(comps);
                break;
            case SHELL_SORT_2:
                new ShellSort2().sort(comps);
                break;
            case MERGE_SORT:
                new MergeSort().sort(comps);
                break;
            case MERGE_SORT_BU:
                new MergeSortBU().sort(comps);
                break;
            case QUICK_SORT:
                new QuickSort().sort(comps);
                break;
            case QUICK_SORT_3WAY:
                new QuickSort3Way().sort(comps);
                break;
            case HEAP_SORT:
                new HeapSort().sort(comps);
                break;
            case HEAP_SORT_SWIM:
                new HeapSortSwim().sort(comps);
                break;
            default:
                break;
        }
        return System.currentTimeMillis() - start;
    }

    public static long timeRandomInput(int alg, int len, int n) {
        long total = 0L;
        Random random = new Random();
        Double[] d = new Double[len];
        while (n-- > 0) {
            for (int i = 0; i < len; i++) {
                d[i] = random.nextDouble();
            }
            total += time(d, alg);
        }
        return total;
    }

    public static void main(String[] args) {
        int len = 1000000;
        int n = 1;
//        long t0 = timeRandomInput(SELECTION_SORT, len, n);
//        long t11 = timeRandomInput(INSERTION_SORT_1, len, n);
//        long t12 = timeRandomInput(INSERTION_SORT_2, len, n);
//        long t21 = timeRandomInput(SHELL_SORT_1, len, n);
//        long t22 = timeRandomInput(SHELL_SORT_2, len, n);
        long t3 = timeRandomInput(MERGE_SORT, len, n);
        long t32 = timeRandomInput(MERGE_SORT_BU, len, n);
        long t4 = timeRandomInput(QUICK_SORT, len, n);
        long t41 = timeRandomInput(QUICK_SORT_3WAY, len, n);
        long t5 = timeRandomInput(HEAP_SORT, len, n);
        long t51 = timeRandomInput(HEAP_SORT_SWIM, len, n);

//        System.out.println("SelectionSort time is " + t0);
//        System.out.println("InsertionSort1 time is " + t11);
//        System.out.println("InsertionSort2 time is " + t12);
//        System.out.println("ShellSort1 time is " + t21);
//        System.out.println("ShellSort2 time is " + t22);
        System.out.println("MergeSort time is " + t3);
        System.out.println("MergeSortBU time is " + t32);
        System.out.println("QuickSort time is " + t4);
        System.out.println("QuickSort3Way time is " + t41);
        System.out.println("HeapSort time is " + t5);
        System.out.println("HeapSort_swim time is " + t51);

    }
}
