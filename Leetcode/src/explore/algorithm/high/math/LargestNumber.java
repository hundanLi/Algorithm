package explore.algorithm.high.math;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-01 18:34
 * 思路：按数字大小排序
 **/
public class LargestNumber {
    public static String largestNumber(int[] num) {
        String[] strings = new String[num.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(num[i]);
        }
        Arrays.sort(strings, (o1, o2) -> {
            String lr = o1 + o2;
            String rl = o2 + o1;
            if (lr.compareTo(rl) > 0) {
                return 1;
            } else if (lr.compareTo(rl) < 0) {
                return -1;
            }
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0 ; i--) {
            sb.append(strings[i]);
        }
        String s = sb.toString();
        if (s.startsWith("0")) {
            return "0";
        }
        return s;
    }

    public static void main(String[] args) {
        int[] num = new int[]{129, 12};
        String largestNumber = largestNumber(num);
        System.out.println(largestNumber);

    }
}
