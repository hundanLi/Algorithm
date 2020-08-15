package explore.bytedance.array;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-12 09:44
 **/
public class KthPermutation {
    public String getPermutation(int n, int k) {
        if(k <= 0) {
            return "";
        }
        int[] cap = new int [n];
        int factorial = 1;
        List<Integer> curList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            factorial *= (i+1);
            cap[n-1-i] = factorial/(i+1);
            curList.add(i);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++){
            int index = (k-1)/cap[i];
            if(index < 0)
                index = 0;
            int val = curList.get(index);
            result.append(val + 1);
            curList.remove(index);
            k = k - cap[i]*index;
        }
        return result.toString();
    }
}
