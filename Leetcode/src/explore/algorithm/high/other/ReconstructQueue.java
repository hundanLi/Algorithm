package explore.algorithm.high.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-03 23:49
 * https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89350/Java-solution-using-Arrays.sort()-and-%22insert-sorting%22-idea
 *
 * 思路：
 * 1.按照身高倒序，比他高（含等高）的人的个数顺序排列队伍；
 * 2.遍历队伍，按照比他高或等高的人数（假设为i）将其插入队伍中相应的（i）位置，因为此时前面的人必定比他高，因此满足要求
 **/
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }

        //排序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> temp = new ArrayList<>();
        for (int[] aPeople : people) {
            temp.add(aPeople[1], aPeople);
        }

        int i = 0;
        for (int[] arr : temp) {
            people[i++] = arr;
        }
        return people;
    }
}
