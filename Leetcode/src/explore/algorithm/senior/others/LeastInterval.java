package explore.algorithm.senior.others;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-11 16:51
 **/
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {

        int[] taskNum = new int[26];
        for (char c : tasks) {
            taskNum[c - 'A']++;
        }
        Arrays.sort(taskNum);
        int time = 0;
        while (taskNum[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (taskNum[25] == 0) {
                    break;
                }
                if (i < 26 && taskNum[25 - i] > 0) {
                    taskNum[25 - i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(taskNum);
        }

        return time;
    }

    /**
     * https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation
     * 总时间 = 任务数 + 空闲块
     */
    public int leastInterval2(char[] tasks, int n) {
        //存储每个任务的个数
        int[] counter = new int[26];
        //相同任务个数的最大值
        int max = 0;
        //有多少个max
        int maxCount = 0;

        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        //首先安排数量最多的任务，保证两个任务之间相隔n后：
        //可能的空区块个数
        int slotPartCount = max - 1;
        //每个空区块的长度，可能并不存在空位置(当maxCount > n时)
        int slotPartLength = n - (maxCount - 1);
        //可能的空位置总数
        int slotCount = slotPartCount * slotPartLength;
        //安排剩余的任务到空位置中(即使没有空位置也可以插队，这样也会满足相同任务间隔n个时间点)
        int availableTasks = tasks.length - max * maxCount;
        //空闲时间段，可能为0(剩余任务> 空位置总数)
        int idles = Math.max(0, slotCount - availableTasks);
        //总时间 = tasks + idles
        return tasks.length + idles;

    }

    public static void main(String[] args) {
        char[] test = new char[]{'G', 'C', 'A', 'H', 'A', 'G', 'G', 'F', 'G', 'J', 'H', 'C', 'A', 'G', 'E',
                'A', 'H', 'E', 'F', 'D', 'B', 'D', 'H', 'H', 'E', 'G', 'F', 'B', 'C', 'G', 'F', 'H', 'J', 'F',
                'A', 'C', 'G', 'D', 'I', 'J', 'A', 'G', 'D', 'F', 'B', 'F', 'H', 'I', 'G'};
        int n = 1;
        LeastInterval leastInterval = new LeastInterval();
        int interval = leastInterval.leastInterval(test, n);
        System.out.println(interval);

    }
}
