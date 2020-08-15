package explore.algorithm.high.design;

import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-01 23:47
 **/
public class MedianFinder {
    /**
     *     //存储大的一般数据
     */
    private PriorityQueue<Integer> minHeap;
    /**
     * //存储小的一般数据，保证最大堆的数据比最小堆多一个
     */
    private PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        //当插入奇数次时，放入最大堆，保证比最小堆多1
        if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
            //如果要num比最小堆的堆顶元素大，则把num插入最小堆，并把该堆顶元素弹出放入最大堆
            if (minHeap.size() > 0 && num > minHeap.element()) {
                minHeap.offer(num);
                num = minHeap.remove();
            }
            maxHeap.offer(num);
        } else {
            //偶数次，插入数据到最小堆
            if (maxHeap.size() > 0 && num < maxHeap.element()) {
                maxHeap.offer(num);
                num = maxHeap.remove();
            }
            minHeap.offer(num);
        }
    }

    public double findMedian() {
        int size = minHeap.size() + maxHeap.size();
        if (size == 0) {
            throw new RuntimeException("无数据！");
        }
        if ((size & 1) == 1) {
            //总数为奇数，返回最大堆的堆顶元素
            return maxHeap.element();
        } else {
            //总数为偶数，返回两个堆顶元素的均值
            return (minHeap.element() + maxHeap.element())/ 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());

    }
}
