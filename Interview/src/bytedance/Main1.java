package bytedance;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-14 10:05
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<List<Integer>> lists = new ArrayList<>(10);

        while (in.hasNextLine()) {
            String s = in.nextLine().trim();
            if ("".equals(s)) {
                break;
            }
            String[] split = s.split(" ");
            List<Integer> list = new ArrayList<>(10);
            for (String num : split) {
                list.add(Integer.parseInt(num));
            }
            lists.add(list);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int minute = bfs(lists, queue);

        System.out.println(minute);

    }

    private static int bfs(List<List<Integer>> lists, Queue<int[]> queue) {
        int minute = 0;
        boolean flag;
        while (queue.size() > 0) {
            flag = false;
            int size = queue.size();
            while (size-- > 0) {
                int[] ints = queue.poll();
                assert ints != null;
                int x = ints[0];
                int y = ints[1];
                if (x > 0 && lists.get(x - 1).get(y) == 1) {
                    lists.get(x - 1).set(y, 2);
                    queue.offer(new int[]{x - 1, y});
                    flag = true;
                }
                if (x < lists.size() - 1 && lists.get(x + 1).get(y) == 1) {
                    lists.get(x + 1).set(y, 2);
                    queue.offer(new int[]{x + 1, y});
                    flag = true;
                }
                if (y > 0 && lists.get(x).get(y - 1) == 1) {
                    lists.get(x).set(y - 1, 2);
                    queue.offer(new int[]{x, y - 1});
                    flag = true;
                }
                if (y < lists.get(0).size() - 1 && lists.get(x).get(y + 1) == 1) {
                    lists.get(x).set(y + 1, 2);
                    queue.offer(new int[]{x, y + 1});
                    flag = true;
                }
            }
            if (flag) {
                minute++;
            }
        }
        for (List<Integer> list : lists) {
            if (list.contains(1)) {
                return -1;
            }
        }
        return minute;
    }
}
