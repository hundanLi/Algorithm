package mock.month1909;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-16 15:43
 **/
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>(1 << n);
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<>(1 << n);
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
