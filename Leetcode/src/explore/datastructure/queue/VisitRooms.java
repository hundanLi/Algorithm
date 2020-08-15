package explore.datastructure.queue;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-07 11:19
 **/
public class VisitRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        return bfs(rooms);
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private boolean bfs(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        List<Integer> room;
        while (!queue.isEmpty()) {
            int roomNum = queue.remove();
            room = rooms.get(roomNum);
            visited[roomNum] = true;
            for (int key : room) {
                if (!visited[key]) {
                    queue.offer(key);
                }
            }
        }
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int roomNum) {
        if (visited[roomNum]) {
            return;
        }
        visited[roomNum] = true;
        List<Integer> room = rooms.get(roomNum);
        for (int key : room) {
            dfs(rooms, visited, key);
        }
    }
}
