package explore.algorithm.high.arraystring;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-16 18:49
 **/
public class Calculate {
    public static int calculate(String s) {
        Deque<Integer> operands = new LinkedList<>();
        Deque<Character> operators = new LinkedList<>();
        List<Character> ops = Arrays.asList('*', '+', '/', '-');
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (ops.contains(c)) {
                operators.offerLast(c);
            } else if (c != ' '){
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                for (int j = i + 1; j < chars.length;j++) {
                    char cc = chars[j];
                    if (!ops.contains(cc)) {
                        sb.append(cc);
                        i++;
                    } else {
                        break;
                    }
                }
                int opr = Integer.parseInt(sb.toString().trim());
                if (!operators.isEmpty() && operators.peekLast() == '*') {
                    operators.pollLast();
                    Integer opl = operands.peekLast();
                    operands.pollLast();
                    operands.offerLast(opl * opr);
                } else if (!operators.isEmpty() && operators.peekLast() == '/') {
                    operators.pollLast();
                    Integer opl = operands.peekLast();
                    operands.pollLast();
                    operands.offerLast(opl / opr);
                } else {
                    operands.offerLast(opr);
                }
            }
        }
        int prod = operands.getFirst();
        operands.pollFirst();
        while (operands.size() > 0) {
            char c = operators.peekFirst();
            operators.pollFirst();
            int r = operands.getFirst();
            operands.pollFirst();
            if (c == '+') {
                prod += r;
            } else {
                prod -= r;
            }
        }
        return prod;
    }

}
