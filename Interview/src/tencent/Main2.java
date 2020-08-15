package tencent;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-09 20:09
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n > 0) {
            n--;
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(sum2(a, b));
        }
    }

    private static int sum(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            if ((i & 1) != 0) {
                sum += -i;
            } else {
                sum += i;
            }
        }
        return sum;
    }


    private static int sum2(int a, int b) {
        //two even
        if ((a & 1) == 0 && (b & 1) == 0) {
            return (a + b) / 2;
        }
        //two odd
        if ((a & 1) != 0 && (b & 1) != 0) {
            return -(a + b) / 2;
        }
        //first odd, second even
        if ((a & 1) != 0 && (b & 1) == 0) {
            return (b - a + 1) / 2;
        }
        //first even, second odd
        if ((a & 1) == 0 && (b & 1) != 0) {
            return -(b - a + 1) / 2;
        }
        return -1;
    }
}
