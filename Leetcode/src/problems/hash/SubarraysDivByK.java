package problems.hash;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-21 14:37
 **/
public class SubarraysDivByK {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        int[] mod = new int[k];
        mod[0] = 1;
        for (int num : nums) {
            sum += num;
            int m = sum % k;
            if (m < 0) {
                m += k;
            }
            ans += mod[m]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(new SubarraysDivByK().subarraysDivByK(nums, k));
    }
}
