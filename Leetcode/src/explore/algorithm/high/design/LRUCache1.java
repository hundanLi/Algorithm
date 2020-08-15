package explore.algorithm.high.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-04 10:35
 **/
public class LRUCache1 {
    private int capacity;
    private Map<Integer, Value> cache;
    private int size;
    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cache = new HashMap<>(capacity);
    }

    public synchronized int get(int key) {
        if (cache.containsKey(key)) {
            Value value = cache.get(key);
            int val = value.val;
            value.lastUse = System.currentTimeMillis();
            value.useTimes++;
            cache.put(key, value);
            return val;
        }
        return -1;
    }

    public synchronized void put(int key, int value) {
        if (size == capacity) {
            remove();
            size--;
        }
        cache.put(key, new Value(value, System.currentTimeMillis(), 1));
        size++;
    }

    private synchronized void remove() {
        Set<Map.Entry<Integer, Value>> entries = cache.entrySet();
        Map.Entry removing = null;
        for (Map.Entry entry : entries) {
            if (removing == null) {
                removing = entry;
            } else {
                Value ev = (Value) entry.getValue();
                Value rv = (Value) removing.getValue();
                if (ev.lastUse < rv.lastUse) {
                    removing = entry;
                } else if (ev.lastUse == rv.lastUse && ev.useTimes < rv.useTimes) {
                    removing = entry;
                }
            }
        }
        cache.remove(removing != null ? removing.getKey() : null);
    }

    class Value {
        int val;
        long lastUse;
        int useTimes;

        Value(int val, long lastUse, int useTimes) {
            this.val = val;
            this.lastUse = lastUse;
            this.useTimes = useTimes;
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            LRUCache1 lruCache = new LRUCache1(2);
            lruCache.put(2, 1);
            lruCache.put(1, 1);
            lruCache.put(2, 3);
            lruCache.put(4, 1);
            System.out.print(lruCache.get(1) + " ");
            System.out.println(lruCache.get(2));

        }

    }
}
