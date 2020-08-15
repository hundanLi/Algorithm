package mock.month1908;

import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-29 11:33
 **/
public class Rand10 {
    public int rand10() {
        while (true) {
            int n = (rand7() - 1) * 7 + rand7();
            if (n <= 40) {
                return n % 10 + 1;
            }
        }
    }

    private int rand7() {
        return new Random().nextInt(7) + 1;
    }

}
