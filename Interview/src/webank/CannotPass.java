package webank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-19 17:24
 **/
public class CannotPass {

    private static boolean dfs(int s, int t, List<List<Integer>> paths, boolean[] visited, boolean[] arrived) {
        boolean arrival = false;
        for (int d : paths.get(s)) {
            if (d == t) {
                arrival = true;
                continue;
            }
            if (!visited[d]) {
                visited[d] = true;
                arrived[d] = true;
                if (dfs(d, t, paths, visited, arrived)) {
                    arrival = true;
                } else {
                    arrived[d] = false;
                }
            }
        }
        return arrival;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s, t;
        List<List<Integer>> paths = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            paths.add(new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            s = in.nextInt();
            t = in.nextInt();
            paths.get(s).add(t);
            paths.get(t).add(s);
        }
        s = in.nextInt();
        t = in.nextInt();
        boolean[] visited = new boolean[n + 1];
        boolean[] arrived = new boolean[n + 1];
        dfs(s, t, paths, visited, arrived);
        int i = 0;
        for (int j = 1; j < arrived.length; j++) {
            if (j == s || j == t) {
                continue;
            }
            if (!arrived[j]) {
                if (i == 0) {
                    i++;
                    System.out.print(j);
                } else {
                    System.out.print(" " + j);
                }
            }
        }
    }
}
