package problems.stack;

/**
 * @author li
 * @version 1.0
 * @date 2020-01-14 10:44
 **/
public class MinAddToMakeValid {
    public int minAddToMakeValid(String s) {
        int leftLoss = 0;
        int rightLoss = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rightLoss++;
            } else {
                if (rightLoss > 0) {
                    rightLoss--;
                } else {
                    leftLoss++;
                }
            }
        }
        return leftLoss + rightLoss;
    }
}
