package tencent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-09 21:20
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (i < n) {
            arr[i++] = in.nextInt();
        }
        int minLen = minLen(n, m, arr);
        System.out.println(minLen);

    }

    private static int minLen(int n, int m, int[] arr) {
        boolean[] visited = new boolean[m + 1];
        int count = 0;
        int minLength = n;
        Queue<Integer> queue = new LinkedList<>();
        for (int e: arr){
            if (e == 0) {
                continue;
            }
            if (!queue.isEmpty() && e == queue.peek()) {
                queue.poll();
            }
            queue.add(e);
            if (!visited[e]) {
                visited[e] = true;
                count++;
            }
            if (count == m) {
                minLength = Math.min(minLength, queue.size());
            }
        }
        return minLength;
    }
}
