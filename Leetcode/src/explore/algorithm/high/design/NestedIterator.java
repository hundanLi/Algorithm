package explore.algorithm.high.design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-04 10:09
 **/
public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new LinkedList<>();
        for (NestedInteger ni : nestedList) {
            dfs(list, ni);
        }
        this.iterator = list.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        if (!this.iterator.hasNext()) {
            return null;
        }
        return iterator.next();
    }

    private void dfs(List<Integer> list, NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            list.add(nestedInteger.getInteger());
            return;
        }
        List<NestedInteger> nestedIntegers = nestedInteger.getList();
        for (NestedInteger ni : nestedIntegers) {
            dfs(list, ni);
        }
    }

    interface NestedInteger {

        /**
         * @return true if this NestedInteger holds a single integer, rather than a nested list.
         */
        boolean isInteger();

        /**
         *  @return the single integer that this NestedInteger holds, if it holds a single integer
         *          Return null if this NestedInteger holds a nested list
         */
        Integer getInteger();

        /**
         *  @return the nested list that this NestedInteger holds, if it holds a nested list
         *          Return null if this NestedInteger holds a single integer
         */
        List<NestedInteger> getList();
    }
}
