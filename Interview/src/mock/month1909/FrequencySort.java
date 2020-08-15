package mock.month1909;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-20 09:59
 **/
public class FrequencySort {

    static class CharFreq {
        char c;
        int freq;

        public CharFreq() {
        }

        public CharFreq(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        CharFreq[] charFreqs = new CharFreq[128];
        for (int i = 0; i < charFreqs.length; i++) {
            charFreqs[i] = new CharFreq();
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charFreqs[c].c = c;
            charFreqs[c].freq++;

        }
        Arrays.sort(charFreqs, (o1, o2) -> o2.freq - o1.freq);
        int i = 0;
        char[] chars = new char[s.length()];
        for (CharFreq charFreq : charFreqs) {
            while (charFreq.freq-- > 0) {
                chars[i++] = charFreq.c;
            }
        }
        return new String(chars);
    }
}
