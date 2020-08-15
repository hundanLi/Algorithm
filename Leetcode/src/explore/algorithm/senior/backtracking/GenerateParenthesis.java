package explore.algorithm.senior.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-26 11:19
 **/
public class GenerateParenthesis {

    /**
     * Approach 1: Brute Force
     */
    public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        if (n < 1) {
            return list;
        }
        generateAll(new char[2 * n], 0, list);
        return list;
    }

    private void generateAll(char[] chars, int pos, List<String> list) {
        if (pos == chars.length) {
            if (valid(chars)) {
                list.add(new String(chars));
            }
        } else {
            chars[pos] = '(';
            generateAll(chars, pos + 1, list);
            chars[pos] = ')';
            generateAll(chars, pos + 1, list);
        }
    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return (balance == 0);
    }

    /**
     * Approach 2: Backtracking
     */
    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        if (n < 1) {
            return list;
        }
        backtrack(list, new char[2 * n], 0, 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, char[] chars, int idx, int open, int close, int max) {
        if (idx == chars.length) {
            list.add(new String(chars));
            return;
        }
        if (open < max) {
            chars[idx] = '(';
            backtrack(list, chars, idx + 1, open + 1, close, max);
        }
        if (close < open) {
            chars[idx] = ')';
            backtrack(list, chars, idx + 1, open, close + 1, max);
        }
    }

}
