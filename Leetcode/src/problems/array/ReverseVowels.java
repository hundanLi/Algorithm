package problems.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-06 10:38
 **/
public class ReverseVowels {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            while (i < chars.length && !vowels.contains(chars[i])) {
                i++;
            }
            while (j >= 0 && !vowels.contains(chars[j])) {
                j--;
            }
            if (i < chars.length && i < j) {
                swap(chars, i++, j--);
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static void main(String[] args) {
        ReverseVowels rv = new ReverseVowels();
        String s = "Hello";
        String vowels = rv.reverseVowels(s);
        System.out.println(vowels);

    }
}
