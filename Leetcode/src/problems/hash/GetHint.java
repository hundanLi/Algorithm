package problems.hash;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-23 20:14
 **/
public class GetHint {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int[] map = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            if (sc == gc) {
                a++;
            } else {
                if (map[sc - '0'] > 0) {
                    map[sc - '0']--;
                    b++;
                }
                map[gc - '0']++;
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            if (sc != gc && map[sc - '0'] > 0) {
                map[sc - '0']--;
                b++;
            }
        }
        return a + "A" + b + "B";
    }
}
