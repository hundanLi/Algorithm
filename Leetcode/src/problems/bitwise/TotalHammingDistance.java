package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-12 15:23
 **/
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    count++;
                }
            }
            sum += count * (len - count);
        }
        return sum;
    }
}
