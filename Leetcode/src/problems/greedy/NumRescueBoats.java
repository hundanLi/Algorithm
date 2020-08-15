package problems.greedy;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-19 10:50
 **/
public class NumRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        int num = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            num++;
        }
        return num;
    }
}
