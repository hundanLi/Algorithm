package problems.bitwise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-16 18:54
 **/
public class SortByBits {
    public int[] sortByBits(int[] arr) {
        Map<Integer, Integer> bits = new HashMap<>(arr.length);
        Integer[] integers = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integers[i] = arr[i];
            int num = arr[i];
            int bit = 0;
            while (num > 0) {
                bit++;
                num = num & (num - 1);
            }
            bits.put(arr[i], bit);
        }
        Arrays.sort(integers, new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (bits.get(o1).equals(bits.get(o2))) {
                    return o1 - o2;
                }
                return bits.get(o1) - bits.get(o2);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = integers[i];
        }
        return arr;
    }

}
