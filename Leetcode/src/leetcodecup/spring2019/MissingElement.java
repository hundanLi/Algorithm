package leetcodecup.spring2019;


/**
 * @author li
 * @version 1.0
 * @date 2019-04-21 15:04
 **/
public class MissingElement {
    public static int missingElement(int[] num, int k) {
        if (num == null || num.length == 0) {
            return k;
        }
        for (int i = 1; i < num.length; i++) {
            int diff = num[i] - num[i - 1];
            if (diff > 1) {
                int j = k - (diff - 1);
                if (j <= 0) {
                    return num[i - 1] + k;
                }
                k = j;
            }
        }
        return num[num.length - 1] + k;
    }

    public static void main(String[] args) {
        int[] num = {746421, 1033196, 1647541, 4775111, 7769817, 8030384};
        int k = 10;
        int element = missingElement(num, k);
        System.out.println(element);
    }
}
