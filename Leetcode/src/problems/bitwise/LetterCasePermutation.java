package problems.bitwise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-13 13:43
 **/
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        int n = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                n++;
            }
        }
        List<StringBuilder> list = new ArrayList<>(1 << n);
        list.add(new StringBuilder());

        for (char c : s.toCharArray()) {
            int size = list.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < size; i++) {
                    list.add(new StringBuilder(list.get(i)));
                    list.get(i).append(Character.toLowerCase(c));
                    list.get(size + i).append(Character.toUpperCase(c));
                }
            } else {
                for (StringBuilder sb : list) {
                    sb.append(c);
                }
            }
        }

        List<String> ans = new ArrayList<>(list.size());
        for (StringBuilder sb : list) {
            ans.add(sb.toString());
        }
        return ans;
    }
}
