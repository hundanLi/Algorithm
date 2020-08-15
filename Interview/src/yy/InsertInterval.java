package yy;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-12 19:33
 **/
public class InsertInterval {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        List<int[]> list = insertAndMerge(l, r);
        StringBuilder sb = new StringBuilder();
        for (int[] a : list) {
            sb.append(",[")
                    .append(a[0]).append(",")
                    .append(a[1]).append("]");
        }
        System.out.println("[" + sb.substring(1) + "]");

    }

    private static List<int[]> insertAndMerge(int l, int r) {
        List<int[]> list = new ArrayList<>(3);
        list.add(new int[]{3, 10});
        list.add(new int[]{20, 30});
        if (l > r) {
            return list;
        }
        list.add(new int[]{l, r});
        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[] cur;
        int[] pre;
        List<int[]> ans = new ArrayList<>(3);
        ans.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            cur = list.get(i);
            pre = ans.get(ans.size() - 1);
            if (cur[0] <= pre[1]) {
                pre[0] = Math.min(cur[0], pre[0]);
                pre[1] = Math.max(cur[1], pre[1]);
            } else {
                ans.add(cur);
            }
        }
        return ans;
    }
}
