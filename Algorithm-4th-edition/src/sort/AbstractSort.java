package sort;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-10 10:52
 **/
public abstract class AbstractSort {
    public abstract void sort(Comparable[] comparables);

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
        for (int i = 1; i < comparables.length; i++) {
            if (less(comparables[i], comparables[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
