package problems.greedy;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-18 11:17
 **/
public class AdvantageCount {
    public static int[] advantageCount(int[] arr, int[] brr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        Arrays.sort(arr);
        int[] res = new int[arr.length];
        int i = 0;
        for (int b : brr) {
            int min = -1;
            int minIndex = -1;
            res[i] = -1;
            for (int j = 0; j < arr.length; j++) {
                int a = arr[j];
                if (a == -1) {
                    continue;
                }
                if (min == -1) {
                    min = a;
                    minIndex = j;
                }
                if (a > b) {
                    res[i] = a;
                    arr[j] = -1;
                    break;
                }
            }
            if (res[i] == -1) {
                res[i] = min;
                arr[minIndex] = -1;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {2, 7, 11, 15};
        int[] B = {1, 10, 4, 11};
        int[] ints = advantageCount(A, B);
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
