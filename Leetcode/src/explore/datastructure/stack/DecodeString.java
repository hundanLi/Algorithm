package explore.datastructure.stack;

import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-06 11:40
 **/
public class DecodeString {
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> repeatNum = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int start = i;
                for (; i < s.length(); i++) {
                    if (s.charAt(i) == '[') {
                        break;
                    }
                }
                int num = Integer.parseInt(s.substring(start, i));
                repeatNum.push(num);
                strings.push(new StringBuilder(sb));
                sb.delete(0, sb.length());
            } else if (s.charAt(i) == ']') {
                Integer num = repeatNum.pop();
                while (num-- > 0) {
                    strings.peek().append(sb);
                }
                sb = strings.pop();
            } else {
                sb.append(s.charAt(i));
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        String string = decodeString(s);
        System.out.println(string);

    }

}
