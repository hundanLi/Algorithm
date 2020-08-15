package problems.greedy;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-19 12:01
 **/
public class BagOfTokensScore {
    public static int bagOfTokensScore(int[] tokens, int p) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Arrays.sort(tokens);
        int maxScore = 0;
        int curScore = 0;
        int lIndex = 0;
        int rIndex = tokens.length - 1;
        while (lIndex <= rIndex) {
            if (p >= tokens[lIndex]) {
                p -= tokens[lIndex++];
                curScore++;
                maxScore = Math.max(curScore, maxScore);
            } else if (curScore > 0) {
                p += tokens[rIndex--];
                curScore--;
            } else {
                break;
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {

        int[] tokens = {33,41,10,91,47,84,98,34,48,70};
        int p = 43;
        int score = bagOfTokensScore(tokens, p);
        System.out.println(score);
    }
}
