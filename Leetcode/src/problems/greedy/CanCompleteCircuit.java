package problems.greedy;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-13 08:06
 **/
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for (int start = 0; start < n; start++) {
            int gasNum = gas[start] - cost[start];
            int i = (start + 1) % n;
            while (i != start) {
                if (gasNum < 0) {
                    break;
                }
                gasNum += gas[i] - cost[i];
                i = (i + 1) % n;
            }
            if (i == start) {
                if (gasNum >= 0) {
                    return start;
                }
            }
        }
        return -1;
    }

    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            //只有一个站点的情况
            if(gas.length == 1 && cost.length == 1){
                return gas[0] >= cost[0] ? 0 : -1;
            }

            //有两个以上的加油站的情况
            int run = 0;//判断当前加油站是否能到达下一个加油站
            int rest = 0;//用来记录从第一个加油站到最后一个加油站中间的剩余的油量
            int start = 0;//起始的加油站

            for(int i = 0; i < gas.length; i++){
                run += (gas[i] - cost[i]);
                rest += (gas[i] - cost[i]);
                if(run < 0){
                    start = i + 1;
                    run = 0;
                }
            }
            return rest >= 0 ? start : -1;
        }
    }
}
