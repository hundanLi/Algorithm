package problems.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-26 10:34
 **/
public class PeekingIterator implements Iterator<Integer> {

    private Integer[] elements;
    private int cursor;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        List<Integer> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        elements = list.toArray(new Integer[0]);
    }

    public Integer peek() {
        return elements[cursor];
    }

    @Override
    public boolean hasNext() {
        return cursor < elements.length;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return elements[cursor++];
        }
        return null;
    }

}
