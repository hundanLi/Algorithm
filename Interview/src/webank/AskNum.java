package webank;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-19 17:11
 **/
public class AskNum {
    private static int help(int n) {
        if (n <= 0) {
            return 1;
        }
        int mod = 1000003;
        int i = 1;
        int ans = 1;
        while (i <= n) {
            ans *= i++;
            if (ans >= mod) {
                ans %= mod;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(help(n));
    }

}
