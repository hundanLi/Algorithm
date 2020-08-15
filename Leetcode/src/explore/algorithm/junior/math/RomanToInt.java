package explore.algorithm.junior.math;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-23 18:36
 **/
public class RomanToInt {
    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            switch (c) {
                case 'I':
                    if (i + 1 < len) {
                        if (chars[i + 1] == 'V') {
                            sum += 4;
                            i++;
                            break;
                        }
                        if (chars[i + 1] == 'X') {
                            sum += 9;
                            i++;
                            break;
                        }
                    }
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if (i + 1 < len) {
                        if (chars[i + 1] == 'L') {
                            sum += 40;
                            i++;
                            break;
                        }
                        if (chars[i + 1] == 'C') {
                            sum += 90;
                            i++;
                            break;
                        }
                    }
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if (i + 1 < len) {
                        if (chars[i + 1] == 'D') {
                            sum += 400;
                            i++;
                            break;
                        }
                        if (chars[i + 1] == 'M') {
                            sum += 900;
                            i++;
                            break;
                        }
                    }
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
                default:

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String test = "III";
        int i = romanToInt(test);
        System.out.println(i);
    }
}
