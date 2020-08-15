package mock.month1907;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-23 08:52
 **/
public class UglyNumber {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for (int i = 0; i < n; i++) {
            int n1 = uglyNums[index1] * 2;
            int n2 = uglyNums[index2] * 3;
            int n3 = uglyNums[index3] * 5;
            int next = Math.min(n1, Math.min(n2, n3));
            uglyNums[i] = next;
            if (next == n1) {
                index1++;
            }
            if (next == n2) {
                index2++;
            }
            if (next == n3) {
                index3++;
            }
        }
        return uglyNums[n - 1];
    }
}
