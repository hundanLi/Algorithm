package explore.datastructure.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-14 11:05
 **/
public class AddBinary {
    public static String addBinary(String a, String b) {
        int[] numsa = new int[a.length()];
        int[] numsb = new int[b.length()];
        for (int i = 0; i < a.length(); i++) {
            numsa[i] = a.charAt(i) - '0';
        }
        for (int i = 0; i < b.length(); i++) {
            numsb[i] = b.charAt(i) - '0';
        }
        int aLen = a.length();
        int bLen = b.length();
        int[] numss = new int[Math.max(aLen, bLen) + 1];
        int carry = 0;
        int i = numss.length - 1;
        while (aLen >= 1 && bLen >= 1) {
            aLen--;
            bLen--;
            int s = numsa[aLen] + numsb[bLen] + carry;
            carry = 0;
            if (s >= 2) {
                s -= 2;
                carry = 1;
            }
            numss[i--] = s;
        }
        while (--aLen >= 0) {
            int s = numsa[aLen] + carry;
            carry = 0;
            if (s >= 2) {
                s -= 2;
                carry = 1;
            }
            numss[i--] = s;
        }
        while (--bLen >= 0) {
            int s = numsb[bLen] + carry;
            carry = 0;
            if (s >= 2) {
                s -= 2;
                carry = 1;
            }
            numss[i--] = s;
        }
        if (carry > 0) {
            numss[0] = carry;
        }
        if (numss[0] != 0) {
            StringBuilder sb = new StringBuilder();
            for (int n : numss) {
                sb.append(n);
            }
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < numss.length; j++) {
                sb.append(numss[j]);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String a = "101111";
        String b = "10";
        System.out.println(addBinary(a, b));
    }
}
