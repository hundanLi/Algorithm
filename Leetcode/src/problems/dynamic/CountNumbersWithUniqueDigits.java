package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-17 0844
 **/
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int[] num = new int[11];
        num[0] = 0;
        num[1] = 10;
        for (int i = 2; i <= n && i <= 10; i++) {
            num[i] = num[i - 1] + 9 * product(9, 9 - i + 2);
        }
        if (n >= 10) {
            return num[10];
        }
        return num[n];
    }

    private int product(int n, int m) {
        int pro = 1;
        for (int i = m; i <= n; i++) {
            pro *= i;
        }
        return pro;
    }

    public static void main(String[] args) {
        int i = new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(3);
        System.out.println(i);

    }
}
