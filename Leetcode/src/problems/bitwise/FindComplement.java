package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-12 13:48
 **/
public class FindComplement {
    public int findComplement(int num) {
        int inv = 0;
        int i = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                inv = inv | (1 << i);
            }
            num >>>= 1;
            i++;
        }
        return inv;
    }

    public static void main(String[] args) {
        System.out.println(new FindComplement().findComplement(5));
    }
}
