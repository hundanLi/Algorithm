package problems.heap;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-18 11:38
 **/
public class RearrangeBarcodes {
    static class NumFreq {
        int num;
        int freq;

        public NumFreq(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>(barcodes.length);
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        PriorityQueue<NumFreq> pq = new PriorityQueue<>(new Comparator<NumFreq>() {
            @Override
            public int compare(NumFreq o1, NumFreq o2) {
                return o2.freq - o1.freq;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new NumFreq(entry.getKey(), entry.getValue()));
        }
        int[] res = new int[barcodes.length];
        int idx = 0;
        while (pq.size() > 1) {
            NumFreq first = pq.remove();
            NumFreq second = pq.remove();
            while ((pq.size() > 0 && second.freq >= pq.element().freq) || (pq.size() == 0 && second.freq > 0)) {
                res[idx++] = first.num;
                res[idx++] = second.num;
                first.freq--;
                second.freq--;
            }
            if (first.freq > 0) {
                pq.offer(first);
            }
            if (second.freq > 0) {
                pq.offer(second);
            }
        }
        // 遗留最后一个字母
        if (pq.size() > 0) {
            res[idx] = pq.remove().num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] barcodes = {1, 1, 1, 2, 2, 2};
        System.out.println(Arrays.toString(new RearrangeBarcodes().rearrangeBarcodes(barcodes)));
    }
}
