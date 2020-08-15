package explore.algorithm.junior.string;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-14 10:42
 **/
public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        int[] map = new int[256];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            map[s.charAt(i)] += 1;
        }
        int rs = -1;
        for (int i = 0; i < 256; i++){
            if (map[i] == 1) {
                int idx = s.indexOf((char)i);
                if (rs < 0 || rs > idx) {
                    rs = idx;
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        String test = "loveleetcode";
        int i = FirstUniqChar.firstUniqChar(test);
        System.out.println(i);
    }
}
