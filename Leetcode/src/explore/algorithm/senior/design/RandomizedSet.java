package explore.algorithm.senior.design;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-10 20:55
 **/
public class RandomizedSet {
    private Set<Integer> set;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = set.size();
        int index = (int) (Math.random() * size);
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            if (i == index) {
                return iterator.next();
            } else if (i < index) {
                iterator.next();
                i++;
            }
        }
        return iterator.next();
    }
}
