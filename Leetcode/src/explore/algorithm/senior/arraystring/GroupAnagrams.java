package explore.algorithm.senior.arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-24 21:43
 **/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return lists;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedS = new String(chars);
            if (map.containsKey(sortedS)) {
                map.get(sortedS).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedS, list);
            }
        }
        lists.addAll(map.values());
        return lists;
    }
}
