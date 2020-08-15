package explore.algorithm.junior.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 18-8-14 上午10:42
 **/
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        List<Integer> zeros = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeros.add(i);
            }
        }
        for (int i : zeros) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == 0) {
                    continue;
                }
                nums[i] = nums[j];
                nums[j] = 0;
                i = j;
            }
            len--;
        }
    }

    public void moveZeroes1(int[] nums) {
        int start = 0;
        int index = 0;
        int length = nums.length;
        while (index < length) {
            if (nums[index] != 0) {
                nums[start++] = nums[index];
            }
            index++;
        }
        while (start < length) {
            nums[start++] = 0;
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0, 1, 0, 3, 12};
        new MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
