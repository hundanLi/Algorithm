package mock.month1909;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-24 19:59
 **/
public class RefuelStation {
    public int minRefuelStops(int target, int tank, int[][] stations) {
        int num = 0;
        int prev = 0;
        PriorityQueue<Integer> gas = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] station : stations) {
            int loc = station[0];
            int cap = station[1];
            if (loc >= target) {
                tank -= (target - prev);
                if (tank >= 0) {
                    return num;
                }
                while (!gas.isEmpty() && tank < 0) {
                    tank += gas.remove();
                    num++;
                }
                return tank >= 0 ? num : -1;
            }
            tank -= (loc - prev);
            while (!gas.isEmpty() && tank < 0) {
                tank += gas.remove();
                num++;
            }
            if (tank < 0) {
                return -1;
            }
            gas.offer(cap);
            prev = loc;
        }
        tank -= (target - prev);
        if (tank >= 0) {
            return num;
        }
        while (!gas.isEmpty() && tank < 0) {
            tank += gas.remove();
            num++;
        }
        return tank >= 0 ? num : -1;
    }

    static class Solution {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {

            if (stations.length == 0) {
                return startFuel >= target ? 0 : -1;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            int sum = startFuel;
            int ans = 0;
            for (int[] station : stations) {
                while (sum < station[0]) {
                    Integer gas = queue.poll();
                    if (gas == null) {
                        return -1;
                    }
                    sum += gas;
                    ans++;
                }
                queue.offer(station[1]);
            }
            while (sum < target) {
                Integer gas = queue.poll();
                if (gas == null) {
                    return -1;
                }
                sum += gas;
                ans++;
            }
            return ans;
        }

    }

    public static void main(String[] args) {
        int target = 50;
        int fuel = 25;
        int[][] stations = new int[][]{{25, 25}, {50, 50}, {100, 50}, {150, 50}};
        System.out.println(new RefuelStation().minRefuelStops(target, fuel, stations));
    }
}
