package webank;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-19 16:42
 **/
public class LastNonZeroNum {
    private static int help(int n) {
        int i = 1;
        int prod = 1;
        while (i <= n) {
            while (prod % 10 == 0) {
                prod /= 10;
            }
            int tmp = i;
            while (tmp % 10 == 0) {
                tmp /= 10;
            }
            prod %= 10;
            tmp %= 10;
            prod *= tmp;
            i++;
        }
        while (prod % 10 == 0) {
            prod /= 10;
        }
        return prod % 10;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(help(n));
    }
}
