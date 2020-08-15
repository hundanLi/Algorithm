package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-25 15:20
 **/
public class SingleNumber3 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        // 1.求只出现一次的两个数字的异或运算结果
        for (int num : nums) {
            xor ^= num;
        }
        // 2.xor只保留最右边的1，其余位置0，得到mask
        int mask = xor & (-xor);
        // 3.可以断定两个数字中在mask的1位处肯定不相同，否则该位异或结果不会等于1
        // 因此可以用mask将数组分成两部分，一部分与mask的与运算结果都为0，另一部分为mask
        // 从而可以将两个唯一数字分离到两个不同组中，并在组内使用异或运算分别求出
        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }

    public int[] singleNumber2(int[] nums) {
        // 保存两个出现一次的数的不同位
        int bitmask = 0;
        for (int n : nums) {
            bitmask ^= n;
        }
        // 取最右边为1的位来区分两个数
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int n : nums) {
            if ((n & diff) != 0) {
                x ^= n;
            }
        }
        return new int[]{x, x ^ bitmask};
    }
}
