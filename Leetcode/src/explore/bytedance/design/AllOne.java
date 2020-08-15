package explore.bytedance.design;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-17 11:14
 **/
public class AllOne {
    private Map<String, Integer> string2count;
    private TreeMap<Integer, Set<String>> count2stringSet;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        string2count = new HashMap<>();
        count2stringSet = new TreeMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        int count = 1;
        if (this.string2count.containsKey(key)) {
            count = this.string2count.get(key);
            count2stringSet.get(count).remove(key);
            if (count2stringSet.get(count).size() == 0) {
                count2stringSet.remove(count);
            }
            count++;
        }
        if (!count2stringSet.containsKey(count)) {
            count2stringSet.put(count, new HashSet<>());
        }
        string2count.put(key, count);
        count2stringSet.get(count).add(key);

    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (string2count.containsKey(key)) {
            int count = string2count.get(key);
            if (count == 1) {
                this.string2count.remove(key);
                // 删除原来的count -> key
                count2stringSet.get(count).remove(key);
                if (count2stringSet.get(count).size() == 0) {
                    count2stringSet.remove(count);
                }
            } else {
                count2stringSet.get(count).remove(key);
                if (count2stringSet.get(count).size() == 0) {
                    count2stringSet.remove(count);
                }
                count--;
                if (!count2stringSet.containsKey(count)) {
                    count2stringSet.put(count, new HashSet<>());
                }
                string2count.put(key, count);
                count2stringSet.get(count).add(key);
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (count2stringSet.size() == 0) {
            return "";
        }
        return count2stringSet.get(count2stringSet.lastKey()).iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (count2stringSet.size() == 0) {
            return "";
        }
        return count2stringSet.get(count2stringSet.firstKey()).iterator().next();
    }
}
