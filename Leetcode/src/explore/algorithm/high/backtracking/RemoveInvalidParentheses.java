package explore.algorithm.high.backtracking;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-27 09:28
 **/
public class RemoveInvalidParentheses {
    private int minRemoved = Integer.MAX_VALUE;
    private Set<String> validExpression = new HashSet<>();

    private void dfs(String s,
                     int index,
                     int leftCount,
                     int rightCount,
                     int removedCount,
                     StringBuilder expression) {

        if (removedCount > minRemoved) {
            return;
        }
        if (index == s.length()) {
            if (leftCount == rightCount) {
                if (removedCount < minRemoved) {
                    validExpression.clear();
                    minRemoved = removedCount;
                }
                validExpression.add(expression.toString());
            }
        } else {
            //非括号字符，直接进入下一步递归
            char c = s.charAt(index);
            int length = expression.length();
            if (c != '(' && c != ')') {
                expression.append(c);
                dfs(s, index + 1, leftCount, rightCount, removedCount, expression);
                //删除新加入的字符进行回溯
                expression.deleteCharAt(length);
            } else {
                //尝试抛弃这个括号直接进入下一步递归
                dfs(s, index + 1, leftCount, rightCount, removedCount + 1, expression);

                //尝试加入这个括号进行递归
                expression.append(c);
                //左括号直接尝试下一步递归
                if (c == '(') {
                    dfs(s, index + 1, leftCount + 1, rightCount, removedCount, expression);
                } else if (leftCount > rightCount) {
                    //当右括号数量小于左括号数量才把当前这个右括号加入
                    dfs(s, index + 1, leftCount, rightCount + 1, removedCount, expression);
                }
                //删除最后一个符号进行回溯
                expression.deleteCharAt(length);
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new LinkedList<>();
        if (s == null || s.length() == 0) {
            list.add("");
            return list;
        }
        dfs(s, 0, 0, 0, 0, new StringBuilder());
        list.addAll(validExpression);
        return list;
    }

    public class Solution {
        private void removeLeft(String s, int matchTo, int removeTo, List<String> results) {
            int matched = 0;
            for(int m=matchTo; m>=0; m--) {
                if (s.charAt(m) == ')') {
                    matched ++;
                } else if (s.charAt(m) == '(') {
                    matched --;
                }
                if (matched >= 0) {
                    continue;
                }
                for(int r=removeTo; r>=m; r--) {
                    //检查是左括号才能删除
                    if (s.charAt(r) != '(') {
                        continue;
                    }
                    if (r==removeTo || s.charAt(r+1) != '(') {
                        removeLeft(s.substring(0, r)+s.substring(r+1), m-1, r-1, results);
                    }
                }
                //如果本次有删除，则留待后面加入到results
                return;
            }
            results.add(s);
        }
        private void removeRight(String s, int matchTo, int removeTo, List<String> results) {
            int matched = 0;
            for(int m=matchTo; m<s.length(); m++) {
                if (s.charAt(m) == '(') {
                    matched ++;
                } else if (s.charAt(m) == ')') {
                    matched --;
                }
                if (matched >= 0) {
                    continue;
                }
                for(int r=removeTo; r<=m; r++) {
                    //检查是右括号才能删除
                    if (s.charAt(r) != ')') {
                        continue;
                    }
                    if (r==removeTo || s.charAt(r-1) != ')') {
                        removeRight(s.substring(0, r)+s.substring(r+1), m, r, results);
                    }
                }
                //如果本次有删除，则留待后面加入到results
                return;
            }
            removeLeft(s, s.length()-1, s.length()-1, results);
        }
        public List<String> removeInvalidParentheses(String s) {
            List<String> results = new ArrayList<>();
            removeRight(s, 0, 0, results);
            return results;
        }
    }

}
