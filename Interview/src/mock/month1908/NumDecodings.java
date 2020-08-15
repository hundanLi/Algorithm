package mock.month1908;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-31 10:17
 **/
public class NumDecodings {
    public int numDecodings(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        long[] count = new long[s.length() + 1];
        count[0] = 1;
        for (int i = 1; i < count.length; i++) {
            int num = s.charAt(i - 1) - '0';
            if (i == 1) {
                count[i] = num > 0 ? 1 : num < 0 ? 9 : 0;
            } else {
                update(count, i, num);
                int pre = s.charAt(i - 2) - '0';
                if (pre == 1) {
                    if (num >= 0) {
                        count[i] += count[i - 2];
                    } else {
                        count[i] += 9 * count[i - 2];
                    }
                } else if (pre == 2) {
                    if (num < 7 && num >= 0) {
                        count[i] += count[i - 2];
                    } else if (num < 0) {
                        count[i] += 6 * count[i - 2];
                    }
                } else if (pre < 0) {
                    if (num >= 0) {
                        count[i] += count[i - 2];
                    } else {
                        count[i] += 9 * count[i - 2];
                    }
                    if (num >= 0 && num < 7) {
                        count[i] += count[i - 2];
                    } else if (num < 0) {
                        count[i] += 6 * count[i - 2];
                    }
                }
            }
            count[i] %= 1000000007;
        }
        return (int) (count[count.length - 1] % 1000000007);
    }

    private void update(long[] count, int i, int num) {
        if (num > 0) {
            count[i] += count[i - 1];
        } else if (num == 0) {
            count[i] += 0;
        } else {
            count[i] += 9 * count[i - 1];
        }
    }

    public static void main(String[] args) {
        String s = "*1";
        NumDecodings numDecodings = new NumDecodings();
        System.out.println(numDecodings.numDecodings(s));
    }
}
