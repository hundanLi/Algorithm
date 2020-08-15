package mock.month1907;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-21 11:01
 **/
public class RomanToInt {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int ans = 0;
        char n;
        int i = 0;
        for (; i < chars.length; i++) {
            char c = chars[i];
            switch (c) {
                case 'I':
                    if (i < chars.length - 1) {
                        n = chars[i + 1];
                        if (n == 'V') {
                            ans += 4;
                            i++;
                        } else if (n == 'X') {
                            ans += 9;
                            i++;
                        } else {
                            ans++;
                        }
                    } else {
                        ans++;
                    }

                    break;
                case 'V':
                    ans += 5;
                    break;
                case 'X':
                    if (i < chars.length - 1) {
                        n = chars[i + 1];
                        if (n == 'L') {
                            ans += 40;
                            i++;
                        } else if (n == 'C') {
                            ans += 90;
                            i++;
                        } else {
                            ans += 10;
                        }
                    } else {
                        ans += 10;
                    }
                    break;

                case 'L':
                    ans += 50;
                    break;

                case 'C':
                    if (i < chars.length - 1) {
                        n = chars[i + 1];
                        if (n == 'D') {
                            ans += 400;
                            i++;
                        } else if (n == 'M') {
                            ans += 900;
                            i++;
                        } else {
                            ans += 100;
                        }
                    } else {
                        ans += 100;
                    }
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'M':
                    ans += 1000;
                    break;
                default:
                    break;
            }
        }
        return ans;
    }
}
