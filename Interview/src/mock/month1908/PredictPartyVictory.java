package mock.month1908;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-06 09:46
 **/
public class PredictPartyVictory {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new ArrayDeque<>(senate.length());
        Queue<Integer> dire = new ArrayDeque<>(senate.length());
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (radiant.size() > 0 && dire.size() > 0) {
            int r = radiant.remove();
            int d = dire.remove();
            if (r < d) {
                radiant.offer(r + length);
            } else {
                dire.offer(d + length);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
