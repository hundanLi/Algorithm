package problems.bitwise;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-16 15:54
 **/
public class XorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixXor = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        }
        int[] results = new int[queries.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = prefixXor[queries[i][0]] ^ prefixXor[queries[i][1] + 1];
        }
        return results;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(new XorQueries().xorQueries(arr, queries)));

    }
}
