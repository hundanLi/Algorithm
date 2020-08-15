package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-15 14:44
 **/
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        int[] num = new int[n];
        num[0] = 1;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for (int i = 1; i < n; i++) {
            int n1 = num[index1] << 1;
            int n2 = num[index2] + (num[index2] << 1);
            int n3 = num[index3] + (num[index3] << 2);
            int next = Math.min(n1, Math.min(n2, n3));
            num[i] = next;
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
        return num[n - 1];
    }
}
