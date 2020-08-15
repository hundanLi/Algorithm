package explore.algorithm.senior.math;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-11 13:06
 **/
public class TitleToNumber {
    public int titleToNumber(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        int exp = chars.length - 1;
        for (char c : chars) {
            int d = c - 'A' + 1;
            sum += d * Math.pow(26, exp);
            exp--;
        }
        return sum;
    }
}
