package problems.greedy;

import java.util.LinkedList;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-13 09:19
 **/
public class RemoveKdigits {
    public static String removeKdigits(String num, int k) {
        LinkedList<Character> list = new LinkedList<>();
        char[] chars = num.toCharArray();
        for (char c : chars) {
            list.add(c);
        }
        while (k > 0) {
            int i;
            boolean flag = false;
            for (i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    list.remove(i);
                    k--;
                    flag = true;
                    break;
                }
            }
            if (i == 0) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) != '0') {
                        break;
                    }
                    list.remove(j);
                    j--;
                }
                if (list.size() == 0) {
                    return "0";
                }
            }
            if (!flag) {
                list.remove(list.size() - 1);
                k--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();

    }

    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        String s = removeKdigits(num, k);
        System.out.println(s);
    }
}
