package ctrip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-04 19:55
 **/
public class TaskSchedule {


    /**
     * 请完成下面这个函数，实现题目要求的功能
     * 当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    */
    private static int schedule(int m,int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        List<Integer> preList = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        List<Integer> tmp;
        for (int i : array) {
            preList.add(i);
        }
        int n = array.length - m;
        while (n-- > 0) {
            curList.clear();
            int minMerge = Integer.MAX_VALUE;
            int minIdx = 0;
            for (int i = 0; i < preList.size() - 1; i++) {
                int merge = preList.get(i) + preList.get(i + 1);
                if (merge < minMerge) {
                    minMerge = merge;
                    minIdx = i;
                }
            }
            for (int i = 0; i < preList.size(); i++) {
                if (i == minIdx) {
                    curList.add(minMerge);
                    i++;
                } else {
                    curList.add(preList.get(i));
                }
            }
            tmp = preList;
            preList = curList;
            curList = tmp;
        }
        int maxTime = 0;
        for (int i : preList) {
            maxTime = Math.max(maxTime, i);
        }
        return maxTime;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
