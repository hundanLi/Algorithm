package problems.array;


/**
 * @author li
 * @version 1.0
 * @date 2019-06-22 17:07
 **/
public class MinSwap {
    public int minSwap(int[] arr, int[] brr) {
        // not1表示不交换arr[i-1]，swap1表示交换arr[i-1]
        // not2表示不交换arr[i]，swap2表示交换arr[i]
        int not1 = 0;
        int swap1 = 1;
        for (int i = 1; i < arr.length; i++) {
            int not2 = Integer.MAX_VALUE;
            int swap2 = Integer.MAX_VALUE;
            if (arr[i - 1] < arr[i] && brr[i - 1] < brr[i]) {
                // 不交换
                not2 = not1;
                // 都交换
                swap2 = swap1 + 1;
            }
            if (arr[i - 1] < brr[i] && brr[i - 1] < arr[i]) {
                // 只交换i-1
                not2 = Math.min(not2, swap1);
                // 只交换 i
                swap2 = Math.min(swap2, not1 + 1);
            }
            swap1 = swap2;
            not1 = not2;
        }
        return Math.min(not1, swap1);
    }
}
