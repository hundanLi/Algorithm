package vip;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-15 19:20
 **/
public class LFUCache {
    private int capacity;

    private Map<Integer, Integer> keyValMap;
    private Map<Integer, Integer> keyCountMap;
    private TreeMap<Integer, Queue<Integer>> countQueueMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyValMap = new HashMap<>(capacity);
        this.keyCountMap = new HashMap<>(capacity);
        this.countQueueMap = new TreeMap<>();

    }

    public void put(int key, int val) {
        set(key, val);
    }

    public void set(int key, int val) {
        if (capacity == 0) {
            return;
        }
        if (!keyValMap.containsKey(key) && keyValMap.size() == capacity) {
            removeKey();
        }
        if (keyValMap.containsKey(key)) {
            // 更新变量，先移除访问记录
            removeQueueItem(key, keyCountMap.get(key));
        }
        keyValMap.put(key, val);
        keyCountMap.put(key, 0);
        addQueueItem(key, 0);
    }

    public int get(int key) {
        if (!keyValMap.containsKey(key)) {
            return -1;
        }
        int count = keyCountMap.get(key);
        removeQueueItem(key, count);
        addQueueItem(key, count + 1);
        keyCountMap.put(key, count + 1);
        return keyValMap.get(key);
    }

    private void removeKey() {
        Map.Entry<Integer, Queue<Integer>> firstEntry = countQueueMap.firstEntry();
        Integer key = firstEntry.getValue().remove();
        keyValMap.remove(key);
        keyCountMap.remove(key);
        if (firstEntry.getValue().size() == 0) {
            countQueueMap.remove(firstEntry.getKey());
        }
    }

    private void removeQueueItem(int key, int count) {
        Queue<Integer> queue = countQueueMap.get(count);
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (next == key) {
                iterator.remove();
                break;
            }
        }
        if (queue.size() == 0) {
            countQueueMap.remove(count);
        }
    }

    private void addQueueItem(int key, int count) {
        countQueueMap.putIfAbsent(count, new LinkedList<>());
        countQueueMap.get(count).offer(key);
    }

}
