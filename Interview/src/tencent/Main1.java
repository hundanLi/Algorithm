package tencent;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-09 19:37
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(change(n, m));
        }
    }

    private static int change(int n, int amount) {
        return amount / n + 1;
    }
}
