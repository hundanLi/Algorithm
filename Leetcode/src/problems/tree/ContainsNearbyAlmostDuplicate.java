package problems.tree;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-25 18:57
 **/
public class ContainsNearbyAlmostDuplicate {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || t < 0) {
            return false;
        }
        long[] longs = new long[nums.length];
        int id = 0;
        for (int n : nums) {
            longs[id++] = n;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if ( i - j <= k && Math.abs(longs[i] - longs[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2147483647};
        int k = 2;
        int t = 3;
        boolean b = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(b);
    }
}
