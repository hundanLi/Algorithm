package mock.month1909;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-24 15:52
 **/
public class FindOcurrences {
    public String[] findOcurrences1(String text, String first, String second) {
        String prefix = first + " " + second + " ";
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            i = text.indexOf(prefix, i);
            if (i < 0) {
                break;
            }
            i += prefix.length();
            int j = text.indexOf(" ", i);
            if (j < 0) {
                j = text.length();
            }
            list.add(text.substring(i, j));
        }
        return list.toArray(new String[0]);
    }

    public String[] findOcurrences(String text, String first, String second){
        String[] strings = text.split(" ");
        List<String> list = new ArrayList<>(strings.length);
        for (int i = 0; i < strings.length - 2; i++) {
            if (strings[i].equals(first) && strings[i + 1].equals(second)) {
                list.add(strings[i + 2]);
            }
        }
        return list.toArray(new String[0]);
    }
}
