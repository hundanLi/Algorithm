package explore.algorithm.junior.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-23 20:06
 **/
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                List<Integer> list = Collections.singletonList(1);
                lists.add(list);
                continue;
            }
            if (i == 2) {
                List<Integer> list = Arrays.asList(1, 1);
                lists.add(list);
                continue;
            }
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j > 0 && j < i - 1) {
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 2).get(j));
                } else {
                    list.add(1);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
