package mock.month1909;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-18 13:24
 **/
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        int cnt = 0;
        Set<String> deadlocks = new HashSet<>(Arrays.asList(deadends));
        if (deadlocks.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        while (queue.size() > 0) {
            int size = queue.size();
            cnt++;
            while (size-- > 0) {
                String state = queue.remove();
                StringBuilder sb;
                // inc 1
                for (int i = 0; i < 4; i++) {
                    sb = new StringBuilder(state);
                    if (sb.charAt(i) < '9') {
                        sb.setCharAt(i, (char) (sb.charAt(i) + 1));
                    } else {
                        sb.setCharAt(i, '0');
                    }
                    String s = sb.toString();
                    if (s.equals(target)) {
                        return cnt;
                    }
                    if (!deadlocks.contains(s) && !visited.contains(s)) {
                        queue.offer(s);
                        visited.add(s);
                    }

                }
                // dec 1
                for (int i = 0; i < 4; i++) {
                    sb = new StringBuilder(state);
                    if (sb.charAt(i) > '0') {
                        sb.setCharAt(i, (char) (sb.charAt(i) - 1));
                    } else {
                        sb.setCharAt(i, '9');
                    }
                    String s = sb.toString();
                    if (s.equals(target)) {
                        return cnt;
                    }
                    if (!deadlocks.contains(s) && !visited.contains(s)) {
                        queue.offer(s);
                        visited.add(s);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";
        System.out.println(new OpenLock().openLock(deadends, target));
    }
}
