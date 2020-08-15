package problems.design;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-28 10:31
 **/
public class RandomizedCollection {
    private ArrayList<Integer> elements;
    private Map<Integer, LinkedHashSet<Integer>> indexMap;
    public RandomizedCollection() {
        elements = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    public boolean insert(int val) {
        boolean alreadyExist = indexMap.containsKey(val);
        if (!alreadyExist) {
            indexMap.put(val, new LinkedHashSet<>());
        }
        indexMap.get(val).add(elements.size());
        elements.add(val);
        return !alreadyExist;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        // 获得该元素值在elements中的任意一个索引
        LinkedHashSet<Integer> indexSetOfVal = indexMap.get(val);
        int indexToReplace = indexSetOfVal.iterator().next();

        // 获取elements最后一个元素的索引集合
        int lastNum = elements.get(elements.size() - 1);
        LinkedHashSet<Integer> indexSetOfLastNum = indexMap.get(lastNum);

        // 用lastNum替代val所在的indexToReplace位置
        elements.set(indexToReplace, lastNum);

        // 将indexToReplace从val索引集合中移除
        indexSetOfVal.remove(indexToReplace);

        // 如果我们删除的不是elements的最后一个元素，则要更新indexSetOfLastNum
        if (indexToReplace != elements.size() - 1) {
            indexSetOfLastNum.remove(elements.size() - 1);
            indexSetOfLastNum.add(indexToReplace);
        }

        // 移除elements中被转移位置的元素（最后一个）
        elements.remove(elements.size() - 1);

        // 如果val已被全部删除，则删除索引集合
        if (indexSetOfVal.isEmpty()) {
            indexMap.remove(val);
        }
        return true;
    }

    public int getRandom() {
        return elements.get((int) (Math.random() * elements.size()));
    }

}
