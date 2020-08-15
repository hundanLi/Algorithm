package mock.month1907;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-22 09:55
 **/
public class ReorderedPowerOf2 {
    private static Set<String> set;
    static {
        set = new HashSet<>();
        set.add("1");
        int num = 1;
        while (true) {
            num <<= 1;
            char[] chars = Integer.toString(num).toCharArray();
            if (chars.length > 10) {
                break;
            }
            Arrays.sort(chars);
            set.add(new String(chars));
        }
    }
    public boolean reorderedPowerOf2(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        Arrays.sort(chars);
        String s = new String(chars);
        return set.contains(s);
    }
}
