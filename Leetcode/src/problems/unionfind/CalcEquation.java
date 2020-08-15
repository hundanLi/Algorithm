package problems.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-29 20:02
 **/
public class CalcEquation {
    Map<String, String> parents = new HashMap<>();
    Map<String, Double> vals = new HashMap<>();
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        for (int i = 0; i < values.length; i++) {
            union(equations[i][0], equations[i][1], values[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            String x = queries[i][0];
            String y = queries[i][1];
            res[i] = (parents.containsKey(x) && parents.containsKey(y) && find(x) == find(y)) ? vals.get(x) / vals.get(y) : -1.0;
        }
        return res;
    }

    private void add(String s) {
        if (parents.containsKey(s)) {
            return;
        }
        parents.put(s, s);
        vals.put(s, 1.0);
    }

    private String find(String s) {
        String p = parents.getOrDefault(s, s);
        if (s != p) {
            String pp = find(p);
            vals.put(s, vals.get(s) * vals.get(p));
            parents.put(s, pp);
        }
        return parents.getOrDefault(s, s);
    }

    private void union(String x, String y, double v) {
        add(x);
        add(y);
        String px = find(x);
        String py = find(y);
        parents.put(px, py);
        vals.put(px, v * vals.get(y) / vals.get(x));
    }
}
