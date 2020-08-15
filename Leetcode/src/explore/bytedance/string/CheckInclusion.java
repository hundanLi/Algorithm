package explore.bytedance.string;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-04 12:36
 **/
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return true;
        }
        if (s2 == null || s2.length() == 0) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        int length = chars1.length;
        for (int i = 0; i <= s2.length() - length; i++) {
            char[] chars2 = s2.substring(i, i + length).toCharArray();
            Arrays.sort(chars2);
            if (equals(chars1, chars2)) {
                return true;
            }
        }
        return false;
    }

    private boolean equals(char[] chars1, char[] chars2) {
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }


    public boolean checkInclusion2(String s1, String s2) {
        int[] record = new int[128];
        for (char c : s1.toCharArray()) {
            record[c]++;
        }
        char[] arr = s2.toCharArray();
        int l = 0, r = 0;
        int len = s1.length();
        while (r < s2.length()) {
            if (record[arr[r]] > 0) {
                record[arr[r]]--;
                r++;
                if ((r - l) == len) {
                    return true;
                }

            } else {
                record[arr[l]]++;
                l++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion ci = new CheckInclusion();
        String s1 = "ab";
        String s2 = "cac";
        System.out.println(ci.checkInclusion2(s1, s2));
    }
}
