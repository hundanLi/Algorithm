package explore.datastructure.binarysearch;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-12 09:50
 **/
public class GreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // l == r
        return letters[l % letters.length];
    }
}
