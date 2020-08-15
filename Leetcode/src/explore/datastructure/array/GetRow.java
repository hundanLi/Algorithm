package explore.datastructure.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-15 10:56
 **/
public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preRow = new LinkedList<>();
        preRow.add(1);
        if (rowIndex == 0) {
            return preRow;
        }
        List<Integer> curRow = new LinkedList<>();
        curRow.add(1);
        curRow.add(1);
        if (rowIndex == 1) {
            return curRow;
        }
        preRow.add(1);
        curRow.clear();
        int index = 2;
        List<Integer> temp;
        while (index <= rowIndex) {
            curRow.add(1);
            for (int i = 1; i < index; i++) {
                curRow.add(preRow.get(i) + preRow.get(i - 1));
            }
            curRow.add(1);
            index++;
            temp = curRow;
            curRow = preRow;
            preRow = temp;
            curRow.clear();

        }
        return preRow;
    }

}
