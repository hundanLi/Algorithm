package problems.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-23 16:02
 **/
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        for (char c : p.toCharArray()) {
            map[c - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 0) {
                continue;
            }
            int[] copy = Arrays.copyOf(map, map.length);
            int j;
            int end = i + p.length();
            for (j = i; j < end; j++) {
                int idx = s.charAt(j) - 'a';
                if (map[idx] == 0) {
                    i = j;
                    break;
                } else if (copy[idx] == 0) {
                    break;
                }
                copy[idx]--;
            }
            if (j == end) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int[] count = new int[26];
        int[] window = new int[26];
        int occurrence = 0;
        for (char c : p.toCharArray()) {
            int idx = c - 'a';
            if (count[idx] == 0) {
                occurrence++;
            }
            count[idx]++;
        }
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        int match = 0;
        while (right < s.length()) {
            int idx = s.charAt(right++) - 'a';
            if (count[idx] > 0) {
                window[idx]++;
                if (window[idx] == count[idx]) {
                    match++;
                }
            }
            while (match == occurrence) {
                if (right - left == p.length()) {
                    list.add(left);
                }
                int ldx = s.charAt(left++) - 'a';
                if (count[ldx] > 0) {
                    window[ldx]--;
                    if (window[ldx] < count[ldx]) {
                        match--;
                    }
                }
            }
        }
        return list;
    }

    public List<Integer> findAnagrams3(String s, String p){
        int[] count = new int[26];
        int[] window = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        int left = 0, right = 0;
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            int idx = s.charAt(right++) - 'a';
            window[idx]++;
            while (count[idx] < window[idx]) {
                window[s.charAt(left++) - 'a']--;
            }
            if (right - left == p.length()) {
                list.add(left);
            }
        }
        return list;
    }
}
