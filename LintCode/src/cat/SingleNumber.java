package cat;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-18 18:50
 **/
public class SingleNumber {
    public int singleNumber(int[] arr) {
        // write your code here
        int ans = 0;
        for (int i : arr) {
            ans ^= i;
        }
        return ans;
    }
}
