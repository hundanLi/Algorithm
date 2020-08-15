package mock.month1909;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-06 13:14
 **/
public class BusesToDestination {
    public int numBusesToDestination1(int[][] routes, int source, int des) {
        if (source == des) {
            return 0;
        }
        if (routes == null || routes.length == 0) {
            return -1;
        }
        Map<Integer, List<Set<Integer>>> stations = new HashMap<>(16);
        for (int[] route : routes) {
            Set<Integer> set = new HashSet<>();
            for (int i : route) {
                set.add(i);
            }
            List<Set<Integer>> list;
            for (int i : route) {
                if (!stations.containsKey(i)) {
                    list = new LinkedList<>();
                } else {
                    list = stations.get(i);
                }
                list.add(set);
                stations.put(i, list);
            }
        }
        int num = 0;
        Set<Integer> pass = new HashSet<>();
        List<Set<Integer>> sets = stations.get(source);
        if (sets == null) {
            return -1;
        }
        Queue<Set<Integer>> queue = new ArrayDeque<>(sets);
        pass.add(source);
        while (queue.size() > 0) {
            num++;
            int size = queue.size();
            while (size-- > 0) {
                Set<Integer> cur = queue.remove();
                if (cur.contains(des)) {
                    return num;
                }
                for (int i : cur) {
                    if (!pass.contains(i)) {
                        queue.addAll(stations.get(i));
                        pass.add(i);
                    }
                }
            }
        }
        return -1;

    }

    public int numBusesToDestination(int[][] routes, int source, int des) {
        if (source == des) {
            return 0;
        }
        int routesNum = routes.length;
        // 维护每个公交站点所处的线路id的列表
        Map<Integer, List<Integer>> map = new HashMap<>(16);
        for (int i = 0; i < routesNum; i++) {
            for (int s : routes[i]) {
                map.putIfAbsent(s, new LinkedList<>());
                map.get(s).add(i);
            }
        }
        // 维护已经过的公交线路
        boolean[] visited = new boolean[routesNum];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        int steps = 0;
        List<Integer> routeIdxs;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            while (size-- > 0) {
                // 取出站点和相应的路线id列表
                int s = queue.remove();
                routeIdxs = map.get(s);
                for (int idx : routeIdxs) {
                    if (!visited[idx]) {
                        visited[idx] = true;
                        for (int station : routes[idx]) {
                            if (station == des) {
                                return steps;
                            }
                            queue.offer(station);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
