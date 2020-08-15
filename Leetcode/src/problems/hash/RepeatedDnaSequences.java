package problems.hash;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-24 11:11
 **/
public class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 11) {
            return Collections.emptyList();
        }
        Map<String, Integer> map = new HashMap<>(16);
        String sub;
        for (int i = 0; i <= s.length() - 10; i++) {
            sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        List<String> list = new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
