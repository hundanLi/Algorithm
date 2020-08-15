package explore.datastructure.binarysearch;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-12 10:33
 **/
public class DuplicateNumber {
    /**
     * 思路：
     *  遍历数组，将元素i保存到num[i-1]的位置，
     *  如果已经有num[i-1]==i，则说明i是重复的。
     */
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];
            if (e != i + 1) {
                if (nums[e - 1] == e) {
                    return e;
                }
                nums[i] = nums[e - 1];
                nums[e - 1] = e;
                i--;
            }
        }
        throw new RuntimeException();
    }
}
