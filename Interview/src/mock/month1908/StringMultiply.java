package mock.month1908;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-27 09:10
 **/
public class StringMultiply {

    public String multiply(String num1, String num2) {
        String result = "0";
        if (result.equals(num1) || result.equals(num2)) {
            return result;
        }
        for (int i = num1.length() - 1; i >= 0; i--) {
            int c = num1.charAt(i) - '0';
            if (i < num1.length() - 1) {
                num2 = num2.concat("0");
            }
            while (c-- > 0) {
                result = sum(result, num2);
            }
        }

        return result;
    }

    private String sum(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        char[] result = new char[len1 > len2 ? len1 + 1 : len2 + 1];

        int i = result.length - 1;
        len1--;
        len2--;
        int carry = 0;
        while (len1 >= 0 || len2 >= 0) {
            int a = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int b = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            len1--;
            len2--;
            int c = carry + a + b;
            carry = 0;
            if (c >= 10) {
                carry = 1;
                c -= 10;
            }
            result[i--] = (char) (c + '0');
        }
        result[i] = (char) (carry + '0');
        if (result[0] == '0') {
            return new String(result, 1, result.length - 1);
        } else {
            return new String(result);
        }
    }
}
