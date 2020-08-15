package tencent;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-20 20:18
 **/
public class WorkTime {
    static class TimeCount {
        int time;
        int count;

        TimeCount(int time, int count) {
            this.time = time;
            this.count = count;
        }
    }

    private static int maxSum(List<TimeCount> nums) {
        nums.sort(Comparator.comparingInt(o -> o.time));
        int maxSum = 0;
        int i = 0;
        int j = nums.size() - 1;
        while (i <= j) {
            maxSum = Math.max(maxSum, nums.get(i).time + nums.get(j).time);
            if (nums.get(i).count > nums.get(j).count) {
                nums.get(i).count -= nums.get(j).count;
                j--;
            } else if (nums.get(i).count < nums.get(j).count) {
                nums.get(j).count -= nums.get(i).count;
                i++;
            } else {
                i++;
                j--;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<TimeCount> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int count = in.nextInt();
            int time = in.nextInt();
            list.add(new TimeCount(time, count));
        }
        System.out.println(maxSum(list));

    }
}
