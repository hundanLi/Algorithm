package explore.algorithm.junior.others;

import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-23 20:31
 **/
public class IsValid {
    public boolean isValid(String s) {
        if (s == null || "".equals(s.trim())) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    stack.push(c);

            }
        }
        return stack.isEmpty();
    }
}
