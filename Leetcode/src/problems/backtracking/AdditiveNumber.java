package problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-27 10:13
 **/
public class AdditiveNumber {
    private List<Long> list = new ArrayList<>();
    private boolean flag = false;

    public boolean isAdditiveNumber(String num) {
        if (num.charAt(0) == '0') {
            list.add(0L);
            track(num, 1);
        } else {
            for (int i = 1; i <= num.length() - 2; i++) {
                try {
                    list.add(Long.parseLong(num.substring(0, i)));
                    track(num, i);
                    if (flag) {
                        break;
                    }
                    list.remove(0);
                } catch (Exception e) {
                    break;
                }
            }
        }
        return flag;
    }

    private void track(String num, int s) {
        if (s == num.length()) {
            flag = list.size() > 2;
            return;
        }
        int len = num.length();
        if (num.charAt(s) == '0') {
            len = s + 1;
        }
        for (int i = s + 1; i <= len; i++) {
            try {
                long n = Long.parseLong(num.substring(s, i));
                if (list.size() < 2) {
                    list.add(n);
                    track(num, i);
                } else {
                    long next = list.get(list.size() - 1) + list.get(list.size() - 2);
                    if (next == n) {
                        list.add(n);
                        track(num, i);
                    } else if (n > next) {
                        break;
                    }
                }
            } catch (Exception e) {
                break;
            }
            if (flag) {
                break;
            }
        }

        if (!flag && list.size() > 1) {
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        String num = "199001200";
        System.out.println(new AdditiveNumber().isAdditiveNumber(num));
    }
}
