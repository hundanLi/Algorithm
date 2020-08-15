import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-20 10:58
 **/
public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        //Code here ;)
        Map<Integer, Integer> map = new HashMap<>(elements.length);
        int idx = 0;
        for(int e: elements) {
            map.put(e, map.getOrDefault(e, 0) + 1);
            if (map.get(e) <= maxOccurrences) {
                elements[idx++] = e;
            }
        }
        int[] arr = new int[idx];
        if (arr.length >= 0) {
            System.arraycopy(elements, 0, arr, 0, arr.length);
        }
        return arr;
    }
}
