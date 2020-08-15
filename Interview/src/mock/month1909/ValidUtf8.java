package mock.month1909;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-10 09:48
 **/
public class ValidUtf8 {
    public boolean validUtf8(int[] nums) {
        int mask = 1 << 7;
        int mask11 = 3 << 6;
        int len = 0;
        for (int num : nums) {
            if ((mask & num) == 0) {
                if (len == 0) {
                    continue;
                } else {
                    return false;
                }
            }
            if (len == 0) {
                int m = mask;
                while ((m & num) != 0) {
                    len++;
                    m = m >> 1;
                }
                len--;
                if (len == 0 || len >= 4) {
                    return false;
                }
            } else {
                if ((mask11 & num) == mask) {
                    len--;
                } else {
                    return false;
                }
            }
        }
        return len == 0;
    }

    public static void main(String[] args) {
        int[] code = {145};
        System.out.println(new ValidUtf8().validUtf8(code));

    }
}
