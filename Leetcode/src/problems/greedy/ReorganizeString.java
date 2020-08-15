package problems.greedy;

import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-17 10:33
 **/
public class ReorganizeString {
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        //统计词频
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        //最大堆
        PriorityQueue<CharCount> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.count == o1.count ? o1.letter - o2.count : o2.count - o1.count);
        for (int i = 0; i < 26; i++) {

            if (count[i] > 0) {
                if (count[i] > (1 + s.length()) / 2) {
                    return "";
                }
                priorityQueue.offer(new CharCount((char) ('a' + i), count[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        //每次从堆中取出最大的两个元素添加到结果字符串的尾部
        while (priorityQueue.size() >= 2) {
            CharCount charCount1 = priorityQueue.remove();
            CharCount charCount2 = priorityQueue.remove();

            sb.append(charCount1.letter);
            sb.append(charCount2.letter);

            // 剩余计数-1
            charCount1.count--;
            charCount2.count--;
            // 重新插入堆中
            if (charCount1.count > 0) {
                priorityQueue.offer(charCount1);
            }
            if (charCount2.count > 0) {
                priorityQueue.offer(charCount2);
            }
        }

        // 如果堆中还剩一个元素，则加到sb末尾
        if (priorityQueue.size() > 0) {
            sb.append(priorityQueue.remove().letter);
        }
        return sb.toString();
    }

    class CharCount {
        char letter;
        int count;

        CharCount(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        String s = "aab";
        String string = reorganizeString.reorganizeString(s);
        System.out.println(string);
    }


    /**
     * 更高效的算法，思路如下：
     *  找出出现频率最高的char，然后要把他们分隔开, 隔一个slot插值
     *  对于其他所有的剩余字符，也是隔一个插入，因为长度小于一半，所以肯定不会重复
     */
    class Solution {
        public String reorganizeString(String s){
            if (s == null || s.length() == 0) {
                return "";
            }
            //词频统计
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            //寻找最大频率的字母
            int maxCount = 0;
            char letter = 0;
            for (int i = 0; i < 26; i++) {
                if (maxCount < count[i]) {
                    maxCount = count[i];
                    letter = (char) ('a' + i);
                }
            }
            //如果最大频率大于一半+1，则无法完成任务
            if (maxCount > (1 + s.length()) / 2) {
                return "";
            }

            //结果集
            char[] res = new char[s.length()];
            //index 维护下一个应该插入的位置
            //隔空插入最大频率字母
            int index = insert(count, res, 0, letter);

            //插入其他字母
            for (int i = 0; i < 26; i++) {
                index = insert(count, res, index, (char)('a' + i));
            }
            return new String(res);
        }

        private int insert(int[] count, char[] res, int index, char letter) {
            int i = letter - 'a';
            while (count[i] > 0) {
                //因为index大于res长度的情况是之前从0开始间隔2插入了频率最高的字符，
                // 所以这里应该是从0和2之间的间隔开始
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = letter;
                count[i]--;
                index += 2;
            }
            //返回下一个能插入的位置
            return index;
        }
    }
}
