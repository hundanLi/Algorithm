package webank;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-11 18:30
 **/
public class ShuixianhuaShu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int begin;
        int end;
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            begin = in.nextInt();
            end = in.nextInt();
            for (int i = begin; i <= end; i++) {
                int sum = 0;
                int temp = i;
                while (i > 0) {
                    int n = i % 10;
                    sum += (n * n * n);
                    i /= 10;
                }
                if (sum == temp) {
                    sb.append(sum).append(" ");
                }
                i = temp;
            }

            if (sb.length() <= 0) {
                System.out.println("no");
            } else {
                System.out.println(sb.toString().trim());
                sb.setLength(0);
            }
        }
    }
}
