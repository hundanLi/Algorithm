package problems.dynamic;


import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-04 13:16
 * 思路：
 **/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        int leftNum = 0;
        int rightNum = 0;
        int res = 0;
        int cur = 0;
        s = s.trim();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ')') {
                rightNum++;
            } else {
                leftNum++;
            }
            if (leftNum == rightNum) {
                cur += rightNum;
                res = Math.max(res, cur);
                leftNum = 0;
                rightNum = 0;
            } else if (leftNum < rightNum){
                cur = 0;
                leftNum = 0;
                rightNum = 0;
            }
        }
        leftNum = 0;
        rightNum = 0;
        cur = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '(') {
                leftNum++;
            } else {
                rightNum++;
            }
            if (leftNum == rightNum) {
                cur += leftNum;
                res = Math.max(res, cur);
                leftNum = 0;
                rightNum = 0;
            } else if (leftNum > rightNum){
                cur = 0;
                leftNum = 0;
                rightNum = 0;
            }
        }
        return res * 2;
    }

    public int longestValidParentheses2(String s) {
        //基于栈的O(N)算法
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && stack.size() > 0 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                if (stack.isEmpty()) {
                    max = i + 1;
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            } else {
                stack.push(i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String s = ")()())";
        int i = new LongestValidParentheses().longestValidParentheses2(s);
        System.out.println(i);
    }
}
