package problems.string;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-20 12:03
 **/
public class IntToRoman {
    private int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = romans.length - 1; i >= 0; i--) {
            while (num > values[i]) {
                sb.append(romans[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
