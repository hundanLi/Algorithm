package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-16 19:12
 **/
public class NumSteps {
    public int numSteps(String s) {
        int steps = 0;
        while (s.length() > 1) {
            steps++;
            if (s.charAt(s.length() - 1) == '1') {
                s = binaryInc(s);
            } else {
                s = binaryRightShift(s);
            }
        }
        return steps;
    }

    public int numSteps1(String s) {
        // "1111"
        int steps = 0;
        char[] chars = s.toCharArray();
        int idx = chars.length - 1;
        while (idx > 0) {
            if (chars[idx] == '1') {
                steps += 2;
                while (--idx >= 0 && chars[idx] == '1') {
                    steps++;
                }
                if (idx >= 0) {
                    chars[idx] = '1';
                }
            } else {
                steps++;
                idx--;
            }
        }
        return steps;
    }

    private String binaryInc(String s) {
        int carry = 0;
        char[] chars = s.toCharArray();
        int i = s.length() - 1;
        if (chars[i] == '1') {
            carry = 1;
            chars[i] = '0';
        }

        while (carry > 0 && --i >= 0) {
            if (chars[i] == '1') {
                chars[i] = '0';
            } else {
                carry = 0;
                chars[i] = '1';
            }
        }
        if (carry > 0) {
            return "1" + String.valueOf(chars);
        }
        return String.valueOf(chars);
    }


    private String binaryRightShift(String s) {
        return s.substring(0, s.length() - 1);
    }
}
