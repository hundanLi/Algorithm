package explore.algorithm.high.sortsearch;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-03 14:57
 * 思路：
 * 1.对原数组排序，得到排序后的辅助数组tmp
 * 2.对原数组的偶数位下标填充tmp的末尾元素
 * 3.对原数组的奇数位下标填充tmp的末尾元素
 **/
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int index = temp.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = temp[index--];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = temp[index--];
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
