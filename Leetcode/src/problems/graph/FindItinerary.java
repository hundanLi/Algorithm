package problems.graph;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-01 13:08
 **/
public class FindItinerary {
    private Map<String, PriorityQueue<String>> map = new HashMap<>();
    private List<String> list = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() < 1) {
            return Collections.emptyList();
        }
        String from;
        String to;
        PriorityQueue<String> neighbor;
        for (List<String> ticket : tickets) {
            from = ticket.get(0);
            to = ticket.get(1);
            if (!map.containsKey(from)) {
                neighbor = new PriorityQueue<>();
                map.put(from, neighbor);
            } else {
                neighbor = map.get(from);
            }
            neighbor.offer(to);
        }
        dfs("JFK");
        Collections.reverse(list);
        return list;
    }

    private void dfs(String start) {
        PriorityQueue<String> neighbor = map.get(start);
        if (neighbor == null) {
            list.add(start);
            return;
        }
        while (neighbor.size() > 0) {
            String pos = neighbor.remove();
            dfs(pos);
        }
        list.add(start);
    }


    public static void main(String[] args) {
        String[][] strs = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        List<List<String>> lists = new ArrayList<>();
        for (String[] str : strs) {
            lists.add(Arrays.asList(str[0], str[1]));
        }
        System.out.println(new FindItinerary().findItinerary(lists));
    }
}
