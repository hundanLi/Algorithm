package sort;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-10 11:11
 **/
public class SelectionSort extends AbstractSort{

    @Override
    public void sort(Comparable[] comparables) {
        for (int i = 0; i < comparables.length; i++) {
            int minIdx = i;
            for (int j = i; j < comparables.length; j++) {
                if (less(comparables[j], comparables[minIdx])){
                    minIdx = j;
                }
            }
            swap(comparables, i, minIdx);
        }
    }
}
