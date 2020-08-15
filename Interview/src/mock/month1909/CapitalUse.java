package mock.month1909;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-22 09:27
 **/
public class CapitalUse {
    public boolean detectCapitalUse(String word) {
        boolean firstCap = false;
        int capNum = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                if (i == 0) {
                    firstCap = true;
                }
                capNum++;
                if (capNum != i + 1) {
                    return false;
                }
            } else {
                if (capNum > 0) {
                    if (!firstCap || capNum > 1) {
                        return false;
                    }
                }
            }

        }
        return true;
    }
}
