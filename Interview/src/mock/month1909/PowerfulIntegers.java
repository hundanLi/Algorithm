package mock.month1909;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-01 09:48
 **/
public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < 21 && Math.pow(x, i) <= bound; i++) {
            for (int j = 0; j < 21 && Math.pow(x, i) <= bound; j++) {
                int v = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (v <= bound) {
                    seen.add(v);
                }
            }
        }
        return new ArrayList<>(seen);
    }

}
