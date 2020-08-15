package mock.month1907;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-19 08:52
 **/
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length();
        int j = num2.length();
        int maxLen = i > j ? i : j;
        char[] chars = new char[maxLen + 1];
        i--;
        j--;
        int k = chars.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {

            int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int s = a + b + carry;
            carry = 0;
            if (s >= 10) {
                s -= 10;
                carry = 1;
            }
            chars[k--] = (char) (s + '0');
        }
        String ans;
        if (carry > 0) {
            chars[0] = (char) (carry + '0');
            ans = String.valueOf(chars);
        } else {
            ans = String.valueOf(chars, 1, chars.length - 1);
        }
        return ans;
    }
}
