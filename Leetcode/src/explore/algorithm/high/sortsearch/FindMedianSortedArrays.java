package explore.algorithm.high.sortsearch;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-03 16:29
 **/
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        int[] num3 = new int[num1.length + num2.length];
        merge(num1, num2, num3);
        if ((num3.length & 1) == 1) {
            return num3[num3.length >> 1];
        } else {
            return (num3[num3.length >> 1] + num3[(num3.length >> 1) - 1]) / 2.0;
        }
    }

    private void merge(int[] num1, int[] num2, int[] num3) {
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                num3[index++] = num1[i++];
            } else {
                num3[index++] = num2[j++];
            }
        }
        while (i < num1.length) {
            num3[index++] = num1[i++];
        }
        while (j < num2.length) {
            num3[index++] = num2[j++];
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3, 4};
        int[] num2 = new int[]{2};
        double v = new FindMedianSortedArrays().findMedianSortedArrays(num1, num2);
        System.out.println(v);
    }
}
