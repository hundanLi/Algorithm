package explore.algorithm.junior.string;

/**
 * @author li
 * @version 1.0
 * @date 18-8-15 上午11:08
 **/
public class ReverseString {

    public String reverseString(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String test = "1534236469";
        System.out.println(new ReverseString().reverseString(test));

    }
}
