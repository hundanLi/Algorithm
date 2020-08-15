package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-16 17:13
 **/
public class NumberOfSteps {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            steps++;
            if ((num & 1) == 0) {
                num >>>= 1;
            } else {
                num--;
            }
        }
        return steps;
    }
}
