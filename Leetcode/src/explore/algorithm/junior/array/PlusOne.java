package explore.algorithm.junior.array;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 18-8-14 上午10:05
 **/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1] += 1;
        if (digits[digits.length - 1] == 10) {
            carry = 1;
            digits[digits.length - 1] -= 10;
        }
        for (int i = digits.length - 2; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] == 10) {
                digits[i]-= 10;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] rs = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                rs[i+1] = digits[i];
            }
            rs[0] = 1;
            return rs;
        }
    }

    public int[] plusOne1(int[] digits) {
        boolean add = true;
        int len = digits.length;
        for (int i = len - 1; i > -1; i--) {
            if (digits[i] == 9 ) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        int[] newArray = new int[len + 1];
        newArray[0] = 1;
        return newArray;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9,8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(new PlusOne().plusOne(digits)));
    }
}
