package explore.algorithm.junior.string;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-14 11:25
 **/
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        boolean rs = true;
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (!('0' <= s.charAt(i) && s.charAt(i) <= '9' || 'a' <= s.charAt(i) && s.charAt(i) <= 'z')) {
                i++;
                continue;
            }
            if (!('0' <= s.charAt(j) && s.charAt(j) <= '9' || 'a' <= s.charAt(j) && s.charAt(j) <= 'z')) {
                j--;
                continue;
            }
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                rs = false;
                break;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        String test = "race a car";
        System.out.println(IsPalindrome.isPalindrome(test));

    }
}
