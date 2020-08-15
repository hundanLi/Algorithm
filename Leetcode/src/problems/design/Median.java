package problems.design;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-23 16:43
 **/
public class Median <E> {
    /**
     *  最小堆，存放大于等于中位数的数字
     */
    private PriorityQueue<E> minPq;

    /**
     *  最大堆，存放小于等于中位数的数字
     */
    private PriorityQueue<E> maxPq;


    /**
     * 当前中位数，当集合元素个数为奇数时，无歧义，当为偶数时，定义中间两个的任意一个为中位数
     */
    private E m;

    public Median() {
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>(Collections.reverseOrder());
    }

    private int compare(E e, E o) {
        @SuppressWarnings("unchecked")
        Comparable<? super E> cpr = (Comparable<? super E>) e;
        return cpr.compareTo(o);
    }

    public void add(E e) {
        if (m == null) {
            m = e;
            return;
        }
        if (compare(e, m) < 0) {
            //小于中位数，放入最大堆
            maxPq.offer(e);
        } else {
            minPq.offer(e);
        }
        if (minPq.size() - maxPq.size() >= 2) {
            // 最小堆元素较多，即大于中位数的多
            // 将m放进最大堆，然后将最小堆的根元素移除
            maxPq.offer(m);
            m = minPq.remove();
        } else if (maxPq.size() - minPq.size() >= 2) {
            minPq.offer(m);
            m = maxPq.remove();
        }
    }

    public void addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
    }

    public E getMedian() {
        return m;
    }

}
