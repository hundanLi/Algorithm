package problems.greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-18 09:16
 **/
public class SplitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String s) {
        if (s == null || s.trim().length() < 3) {
            return Collections.emptyList();
        }
        int n = s.length();

        for (int i = 0; i < Math.min(10, n); i++) {
            // 开头有连续0，直接退出
            if (s.charAt(0) == '0' && i > 0) {
                break;
            }
            // 第一个数
            long first = Long.valueOf(s.substring(0, i + 1));
            // 如果大于等于Integer上限，直接退出
            if (first >= Integer.MAX_VALUE) {
                break;
            }

            //维护结果集
            List<Integer> fib = new LinkedList<>();
            //查找下一个数
            search:
            for (int j = i + 1; j < Math.min(10, n); j++) {
                // 尝试第二个数
                if (s.charAt(i + 1) == '0' && j > i + 1) {
                    break ;
                }
                long second = Long.valueOf(s.substring(i + 1, j + 1));
                if (second >= Integer.MAX_VALUE) {
                    break;
                }

                // 添加前两个数
                fib.add((int) first);
                fib.add((int) second);

                // 搜索第三个以上的数
                int k = j + 1;
                while (k < n) {
                    long next = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
                    String nextStr = String.valueOf(next);
                    // 是否存在下一个fib数
                    if (next < Integer.MAX_VALUE && s.substring(k).startsWith(nextStr)) {
                        k += nextStr.length();
                        fib.add((int) next);
                    } else {
                        // 搜索失败，清空fib列表，尝试将第二个数换别的
                        fib.clear();
                        continue search;
                    }
                }
                if (fib.size() >= 3) {
                    return fib;
                }
            }
        }
        return Collections.emptyList();
    }

}
