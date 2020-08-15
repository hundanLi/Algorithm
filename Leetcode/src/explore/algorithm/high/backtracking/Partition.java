package explore.algorithm.high.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-26 21:43
 **/
public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new LinkedList<>();
        if (s == null) {
            return lists;
        }
        List<String> list = new LinkedList<>();
        partition(lists, list, 0, s);
        return lists;
    }

    private void partition(List<List<String>> lists, List<String> list, int index, String s) {
        if (index == s.length()) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(index, i))) {
                list.add(s.substring(index, i));
                partition(lists, list, i, s);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int begin = 0;
        int end = str.length() - 1;
        while (begin < end) {
            if (str.charAt(begin) != str.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
