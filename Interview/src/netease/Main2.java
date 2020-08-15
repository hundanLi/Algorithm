package netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-02 19:39
 **/
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        Arrays.sort(num);
        System.out.println(helper(num));

    }

    private static int helper(int[] num) {
        int count = 0;
        for (int i = 0; i < num.length - 2; i++) {
            for (int j = i + 1; j < num.length - 1; j++) {
                int gcd = gcd(num[i], num[j]);
                if (gcd == 1) {
                    count += num.length - j - 1;
                    continue;
                }
                for (int k = j + 1; k < num.length; k++) {
                    if (gcd(num[k], gcd) == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static int gcd(int i, int j) {
        while (j != 0) {
            int temp = i % j;
            i = j;
            j = temp;
        }
        return i;
    }
}
