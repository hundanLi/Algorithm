package webank;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-11 19:48
 **/
public class Jump {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] num = new int[t];
        for (int i = 0; i < t; i++) {
            num[i] = in.nextInt();
        }
        for (int n : num) {
            System.out.println(helper(n));
        }
    }

    private static int helper(int n) {
        if (n == 1) {
            return 0;
        }
        int temp = n;
        int count = 0;
        while (n != 1) {
            if (count > 1 && n == temp) {
                return -1;
            } else {
                count++;
                if ((n & 1) == 1) {
                    n = 3 * n + 1;
                } else {
                    n /= 2;
                }
            }
        }
        return count;
    }
}
