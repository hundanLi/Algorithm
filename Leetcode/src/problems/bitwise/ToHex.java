package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-11 21:59
 **/
public class ToHex {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        int mask = 0x0f;
        String[] runes = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        StringBuilder result = new StringBuilder();
        for (int j = 0; num != 0 && j < 8; j++) {
            int r = num & mask;
            result.insert(0, runes[r]);
            num >>>= 4;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int num = -1;
        System.out.println(new ToHex().toHex(num));
        System.out.println(Integer.toHexString(num));
    }

}
