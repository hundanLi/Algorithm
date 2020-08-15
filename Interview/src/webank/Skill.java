package webank;

import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-11 19:59
 **/
public class Skill {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        int time = 0;
        while (m < n) {
            time += m * k;
            n -= m;
        }
        time += n * k;
        System.out.println(time);
    }
}
