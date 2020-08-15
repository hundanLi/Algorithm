package problems.stack;

/**
 * @author li
 * @version 1.0
 * @date 2020-01-14 14:33
 *
 * 1003
 **/
public class IsValid {

    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int i = -1;
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                if (i >= 1 && stack[i] == 'b' && stack[i - 1] == 'a') {
                    i -= 2;
                } else {
                    return false;
                }
            } else {
                stack[++i] = c;
            }
        }
        return i == -1;
    }

    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}
