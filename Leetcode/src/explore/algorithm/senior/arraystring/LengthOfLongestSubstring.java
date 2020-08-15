package explore.algorithm.senior.arraystring;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-24 23:03
 **/
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        int len = 0;
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];
            if (lastIndex.containsKey(c)) {
                maxLen = Math.max(maxLen, len);
                int newI = lastIndex.get(c);
                int j = newI;
                while (j++ < i) {
                    lastIndex.remove(chars[j]);
                }
                i = newI;
                len = 0;
            } else {
                lastIndex.put(c, i);
                len++;
            }
        }
        return Math.max(maxLen, len);
    }

    public static int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        int[] vis = new int[257];
        int len = s.length();
        int left = -1;
        Arrays.fill(vis,-1);
        for(int i = 0; i < len; i++) {
            if(vis[s.charAt(i)] > left) {
                left = vis[s.charAt(i)];
            }
            ans = Math.max(ans,i - left);
            vis[s.charAt(i)] = i;
        }

        return ans;
    }
    public static void main(String[] args) {
        String test = "dvdf";
        int i = lengthOfLongestSubstring2(test);
        System.out.println(i);
    }
}
