package explore.algorithm.senior.others;

import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-11 15:44
 **/
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int rs;
        int a;
        int b;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    rs = a + b;
                    stack.push(rs);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    rs = b - a;
                    stack.push(rs);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    rs = a * b;
                    stack.push(rs);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    rs = b / a;
                    stack.push(rs);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
