package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-11 15:09
 **/
public class ValidUtf8 {
    public boolean validUtf8(int[] data) {
        int[] masks = {0xf8, 0xf0, 0xe0, 0x80};
        int start = 0xc0;
        for (int i = 0; i < data.length; i++) {
            int bytes = 4;
            int num = data[i];
            for (int mask : masks) {
                if ((mask & num) == (mask & (mask - 1))) {
                    break;
                }
                bytes--;
            }
            if (bytes < 1 || i + bytes > data.length) {
                return false;
            }
            if (bytes == 1) {
                continue;
            }

            for (int j = 1; j < bytes; j++) {
                num = data[i + j];
                if ((num & start) != (start & (start - 1))) {
                    return false;
                }
            }
            i += bytes - 1;
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] data = {235, 140, 4};
//        int[] data = {197, 130, 1};
        int[] data = {255};
        System.out.println(new ValidUtf8().validUtf8(data));
    }
}
