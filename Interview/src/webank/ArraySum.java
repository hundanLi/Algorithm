package webank;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-11 18:11
 **/
public class ArraySum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double num = in.nextDouble();
            int m = in.nextInt();
            double sum = 0.0;
            for (int i = 0; i < m; i++) {
                sum += num;
                num = Math.sqrt(num);
            }
            System.out.printf("%.2f", sum);
            System.out.println();
        }
    }
}
