package mock.month1908;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-02 09:09
 **/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[l++] = nums[i];
            }
        }
        return l + 1;
    }
}
