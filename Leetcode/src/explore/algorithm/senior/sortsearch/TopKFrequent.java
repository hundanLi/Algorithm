package explore.algorithm.senior.sortsearch;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-27 10:22
 **/
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        //队列首元素是指定排序规则的最小值
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1, (o1, o2) -> map.get(o1) - map.get(o2));
        //keep top k frequent element in the heap
        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        //build the result
        List<Integer> list = new LinkedList<>();
        while (heap.size() > 0) {
            list.add(heap.poll());
        }
        Collections.reverse(list);
        return list;
    }

}
