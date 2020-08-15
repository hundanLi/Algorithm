package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-14 13:54
 **/
public class MaxAbsValExpr {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return 0;
        }
        int[][] maxmin = new int[4][2];
        for (int i = 0; i < maxmin.length; i++) {
            maxmin[i][0] = Integer.MIN_VALUE;
            maxmin[i][1] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < arr1.length; i++) {
            int x = arr1[i], y = arr2[i];
            maxmin[0][0] = Math.max(maxmin[0][0], x + y + i);
            maxmin[0][1] = Math.min(maxmin[0][1], x + y + i);
            maxmin[1][0] = Math.max(maxmin[1][0], x + y - i);
            maxmin[1][1] = Math.min(maxmin[1][1], x + y - i);
            maxmin[2][0] = Math.max(maxmin[2][0], x - y + i);
            maxmin[2][1] = Math.min(maxmin[2][1], x - y + i);
            maxmin[3][0] = Math.max(maxmin[3][0], x - y - i);
            maxmin[3][1] = Math.min(maxmin[3][1], x - y - i);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < maxmin.length; i++) {
            ans = Math.max(ans, maxmin[i][0] - maxmin[i][1]);
        }
        return ans;
    }

    public int maxAbsValExpr2(int[] arr1, int[] arr2) {
        int[][] arrs = {{1,1},{1,-1},{-1,1},{-1,-1}};
        int res = 0;
        for(int[] arr: arrs){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i =0; i<arr1.length; i++){
                int result = arr1[i] * arr[0] + arr2[i] * arr[1] + i;
                if(max < result){
                    max = result;
                }
                if(min > result){
                    min = result;
                }
            }
            if(res < max - min){
                res = max - min;
            }
        }
        return res;
    }
}
