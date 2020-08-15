package problems.greedy;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-18 09:39
 **/
public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (ten > 0) {
                    ten--;
                    if (five == 0) {
                        return false;
                    }
                    five--;
                } else {
                    if (five < 3) {
                        return false;
                    }
                    five -= 3;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 5, 10, 5, 10, 10, 10, 20};
        boolean b = lemonadeChange(bills);
        System.out.println(b);
    }
}
