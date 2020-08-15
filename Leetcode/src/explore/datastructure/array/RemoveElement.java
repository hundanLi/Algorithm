package explore.datastructure.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-15 09:55
 **/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
            i++;
        }
        return k;
    }
}
