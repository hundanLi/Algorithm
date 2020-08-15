package tencent;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-09 20:33
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int score = in.nextInt();
        int i = n;
        while (i > 0) {
            i--;
            int j = in.nextInt();
        }
        System.out.println(num(n, score));

    }

    private static BigDecimal num(int n, int score) {
        if (score == 0) {
            return new BigDecimal((n * 2) % (int) (Math.pow(10, 9) + 7));
        }
        return (multiple(n).divide(multiple(n - score - 1)).divide(multiple(score))).multiply(new BigDecimal(2)).remainder(new BigDecimal((int) (Math.pow(10, 9) + 7)));
    }

    private static BigDecimal multiple(int n) {
        BigDecimal m = new BigDecimal(1);
        for (int i = 1; i <= n; i++) {
            m = m.multiply(new BigDecimal(i));
        }
        return m;
    }
}
