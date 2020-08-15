package explore.datastructure.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-09 10:43
 **/
public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>(16);
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length && i <= minSum; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (i + j > minSum) {
                    break;
                }
                if (list1[i].equals(list2[j])) {
                    int sum = i + j;
                    if (sum <= minSum) {
                        map.put(list1[i], sum);
                        minSum = sum;
                    }
                    break;
                }
            }
        }
        String[] ans = new String[map.size()];
        int i = 0;
        for (String s : map.keySet()) {
            ans[i++] = s;
        }
        return ans;
    }

    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> map = new HashMap<>(list1.length);
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }
            List<String> list = new ArrayList<>(list1.length);
            int minSum = Integer.MAX_VALUE;
            for (int i = 0; i < list2.length; i++) {
                if (map.containsKey(list2[i])) {
                    int sum = map.get(list2[i]) + i;
                    if (sum < minSum) {
                        list.clear();
                        minSum = sum;
                        list.add(list2[i]);
                    } else if (sum == minSum) {
                        list.add(list2[i]);
                    }
                }
            }
            return list.toArray(new String[0]);
        }
    }
}
