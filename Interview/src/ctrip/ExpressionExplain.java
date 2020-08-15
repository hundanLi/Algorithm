package ctrip;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-04 19:35
 **/
public class ExpressionExplain {

    /**
     * 请完成下面这个函数，实现题目要求的功能
     */
    private static String resolve(String expr) {
        if (expr == null || expr.length() == 0) {
            return "";
        }
        Stack<Integer> stack = new Stack<>();
        char[] chars = expr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return "";
                }
                int begin = stack.pop();
                reverseChar(chars, begin, i);
            }
        }
        if (!stack.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '(' && c != ')') {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    private static void reverseChar(char[] chars, int begin, int end) {
        while (begin < end) {
            while (chars[begin] == '(' || chars[begin] == ')') {
                begin++;
                if (begin >= end) {
                    return;
                }
            }
            while (chars[end] == '(' || chars[end] == ')') {
                end--;
                if (begin >= end) {
                    return;
                }
            }
            char tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
            end--;
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
