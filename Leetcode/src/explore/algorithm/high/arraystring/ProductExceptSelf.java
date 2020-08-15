package explore.algorithm.high.arraystring;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-11 22:44
 **/
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //先从左边连乘（不包括当前位置元素），把结果赋给当前位置
        int[] rs = new int[nums.length];
        int len = nums.length;
        int prod = 1;
        for (int i = 0; i < len; i++) {
            rs[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        //再从右边开始连乘（不包括当前元素，然后将当前位置处值 = 原来值* 连乘值）
        for (int i = len - 1; i >= 0; i--) {
            rs[i] *= prod;
            prod *= nums[i];
        }
        return rs;
    }
}
