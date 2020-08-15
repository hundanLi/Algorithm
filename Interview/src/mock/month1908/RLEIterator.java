package mock.month1908;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-03 10:59
 **/
public class RLEIterator {
    private List<int[]> list;

    public RLEIterator(int[] code) {
        int len = code.length;
        list = new LinkedList<>();
        for (int i = 0; i < len - 1; i++) {
            int c = code[i++];
            int v = code[i];
            list.add(new int[]{c, v});
        }
    }

    public int next(int n) {
        int v = -1;
        while (!list.isEmpty() && n > 0) {
            int[] cv = list.get(0);
            if (cv[0] >= n) {
                cv[0] -= n;
                n = 0;
                v = cv[1];
            } else {
                n -= cv[0];
                cv[0] = 0;
            }
            if (cv[0] == 0) {
                list.remove(0);
            }

        }
        return v;
    }
}
