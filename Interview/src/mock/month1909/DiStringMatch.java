package mock.month1909;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-05 10:08
 **/
public class DiStringMatch {
    public int[] diStringMatch(String s) {
        int length = s.length();
        int[] ans = new int[length + 1];
        int iNum = -1;
        int dNum = length;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                ans[i] = ++iNum;
            } else {
                ans[i] = dNum--;
            }
        }
        ans[length] = ++iNum;
        return ans;
    }
}
