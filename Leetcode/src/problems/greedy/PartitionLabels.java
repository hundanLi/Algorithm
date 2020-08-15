package problems.greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-17 10:21
 **/
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return Collections.emptyList();
        }
        //维护各字母的最大索引位置
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i;
        }
        //维护当前搜索区间内字母的最大索引
        int maxIndex = 0;

        //维护当前搜索区间的开始位置
        int start = 0;

        //结果集
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            maxIndex = Math.max(maxIndex, index[s.charAt(i) - 'a']);
            //当前搜索区间已无更大索引
            if (i == maxIndex) {
                list.add(maxIndex - start + 1);
                start = i + 1;
            }
        }
        return list;
    }
}
