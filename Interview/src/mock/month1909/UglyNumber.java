package mock.month1909;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-02 08:39
 **/
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (num != 1) {
            if (num % 5 == 0) {
                num /= 5;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 2 == 0) {
                num /= 2;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int num = -2147483648;
        System.out.println(new UglyNumber().isUgly(num));
    }
}
