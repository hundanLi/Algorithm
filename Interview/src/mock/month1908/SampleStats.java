package mock.month1908;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-03 11:26
 **/
public class SampleStats {
    public double[] sampleStats(int[] count) {
        int min = 255;
        int max = 0;
        int feq = 0;
        double mid = 0;
        double sum = 0;
        int cnt = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                min = min < i ? min : i;
                max = max > i ? max : i;
                feq = count[feq] > count[i] ? feq : i;
                sum += i * count[i];
                cnt += count[i];
            }
        }
        double ave = sum / cnt;
        int num = 0;
        int pre = 0;
        int midIdx = (cnt + 1) / 2;
        for (int i = 0; i < 256; i++) {
            num += count[i];
            if (num == midIdx) {
                if (cnt % 2 != 0) {
                    mid = i;
                    break;
                } else {
                    pre = i;
                }
            } else if (num > midIdx) {
                if (num - count[i] < midIdx) {
                    pre = i;
                }
                if (cnt % 2 != 0) {
                    mid = i;
                } else {
                    mid = ((double) (pre + i)) / 2;
                }
                break;
            }
        }
        return new double[]{min, max, ave, mid, feq};
    }
}
