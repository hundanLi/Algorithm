package problems.graph;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-19 15:28
 **/
public class NetworkDelayTime {
    private Node[] nodes;

    public int networkDelayTime(int[][] times, int n, int k) {
        initGraph(times, n);
        int[] time = dijkstra(k, n);
        int max = 0;
        for (int t : time) {
            max = Math.max(max, t);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    private void initGraph(int[][] times, int n) {
        nodes = new Node[n+1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] time : times) {
            nodes[time[0]].edges.add(new Edge(time[0], time[1], time[2]));
        }
    }

    private int[] dijkstra(int s, int n) {
        int[] time = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            time[i] = Integer.MAX_VALUE;
        }
        time[s] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> time[o]));
        queue.offer(s);
        int source;
        while (!queue.isEmpty()) {
            source = queue.remove();
            for (Edge edge : nodes[source].edges) {
                int target = edge.target;
                if (time[target] > time[source] + edge.distance) {
                    time[target] = time[source] + edge.distance;
                    queue.remove(target);
                    queue.offer(target);
                }
            }
        }
        return time;
    }

    private static class Node {
        int idx;
        Set<Edge> edges;

        public Node(int idx) {
            this.idx = idx;
            edges = new HashSet<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }

            Node node = (Node) o;

            return idx == node.idx;
        }

        @Override
        public int hashCode() {
            return idx;
        }
    }

    private static class Edge {
        int source;
        int target;
        int distance;

        Edge(int source, int target, int distance) {
            this.source = source;
            this.target = target;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Edge)) {
                return false;
            }

            Edge edge = (Edge) o;

            if (source != edge.source) {
                return false;
            }
            if (target != edge.target) {
                return false;
            }
            return distance == edge.distance;
        }

        @Override
        public int hashCode() {
            int result = source;
            result = 31 * result + target;
            result = 31 * result + distance;
            return result;
        }
    }
}
