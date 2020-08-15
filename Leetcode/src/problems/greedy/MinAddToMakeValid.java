package problems.greedy;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-19 11:41
 **/
public class MinAddToMakeValid {
    public int minAddToMakeValid(String s) {
        //维护'('的个数
        int left = 0;
        //维护需要添加的'('的个数
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    num++;
                }
            }
        }
        //最终额外需要添加的')'的数量=left
        return num + left;
    }
}
