package problems.dynamic;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-17 18:06
 **/
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset0(int[] num) {
        if (num == null || num.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(num);
        List<List<Integer>> dp = new LinkedList<>();
        int maxSize = 1;
        int index = 0;
        List<Integer> prefixList;
        List<Integer> preList;

        for (int i = 0; i < num.length; i++) {
            List<Integer> list = new LinkedList<>();
            prefixList = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                preList = dp.get(j);
                if (num[i] % preList.get(preList.size() - 1) == 0 && prefixList.size() < preList.size()) {
                    prefixList = preList;
                }
            }
            list.addAll(prefixList);
            list.add(num[i]);
            dp.add(list);
            if (list.size() > maxSize) {
                maxSize = list.size();
                index = dp.size() - 1;
            }
        }
        return dp.get(index);
    }


    public List<Integer> largestDivisibleSubset1(int[] num){
        if (num == null || num.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(num);

        int[] dp = new int[num.length];
        int[] maxFactorIndex = new int[num.length];

        Arrays.fill(dp, 1);
        for (int i = 0; i < num.length; i++) {
            maxFactorIndex[i] = i;
            for (int j = 0; j < i; j++) {
                if (num[i] % num[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    maxFactorIndex[i] = j;
                }
            }
        }
        int max = dp[0];
        int index = 0;
        for (int i = 1; i < num.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        List<Integer> list = new ArrayList<>(num.length);
        for (int i = 0; i < max; i++) {
            list.add(num[index]);
            index = maxFactorIndex[index];
        }
        return list;
    }
}
