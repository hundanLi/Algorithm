package explore.algorithm.high.arraystring;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-15 23:45
 **/
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int[] counts = new int[len];
        for (int n : nums) {
            if (counts[n] >= 1) {
                return n;
            } else {
                counts[n] += 1;
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}
