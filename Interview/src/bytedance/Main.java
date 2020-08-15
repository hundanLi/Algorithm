package bytedance;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-14 11:42
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println(0);
            return;
        }
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = 1; i < n; i++) {
            if (num[i - 1] >= num[i]) {
                dp[i] = 0;
            } else {
                dp[i] = num[i] - num[i - 1] + dp[i + 1];
            }
        }
        if (dp[1] < num[0]) {
            dp[0] = dp[1] + num[0];
        } else {
            dp[0] = (dp[1] + num[0]) / 2;
        }
        System.out.println(dp[0]);

    }
}
