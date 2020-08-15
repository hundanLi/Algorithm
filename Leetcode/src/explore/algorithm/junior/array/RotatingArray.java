package explore.algorithm.junior.array;

/**
 * @author li
 * @version 1.0
 * @date 18-8-11 上午10:08
 **/
public class RotatingArray {
    public void rotate(int[] nums, int k) {
        int last = nums.length - 1;
        for (int i = 0; i < k; i++) {
            int tmp = nums[last];
            System.arraycopy(nums, 0, nums, 1, last);
            nums[0] = tmp;
        }
    }

    public void rotate1(int[] nums, int k) {
        int[] tmpArr = new int[nums.length];
        k %= nums.length;
        for (int i = 0; i < nums.length; i++) {
            tmpArr[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmpArr[i];
        }
    }
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,4,5,1,3,3,8,0};
        int k = 2;
        RotatingArray rotatingArray = new RotatingArray();
        rotatingArray.rotate1(nums,k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

