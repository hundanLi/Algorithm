package problems.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-23 13:31
 **/
public class FindWords {
    private String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            int row = -1;
            boolean flag = true;
            for (char c : word.toCharArray()) {
                c = Character.toLowerCase(c);
                for (int i = 0; i < rows.length; i++) {
                    if (rows[i].indexOf(c) != -1) {
                        if (row == -1) {
                            row = i;
                        } else if (row != i) {
                            flag = false;
                            break;
                        }
                    } else {
                        if (row == i) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }
}
