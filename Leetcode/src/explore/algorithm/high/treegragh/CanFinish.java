package explore.algorithm.high.treegragh;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-24 20:52
 **/
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        //统计第i门课有多少先修课程（入度数），先修课程为零（入度=0）的所有编号便是dfs的起点
        int[] preCourses = new int[numCourses];
        //使用邻接矩阵构建有向图
        int[][] graph = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            //存在先后关系，加入一条有向边
            graph[prerequisite[1]][prerequisite[0]] = 1;
            //先修课程+1
            preCourses[prerequisite[0]]++;
        }
        //寻找入度为零的结点作为首修课程
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (preCourses[i] == 0) {
                queue.offer(i);
            }
        }
        //BFS检测环
        bfs(queue, graph, preCourses);

        for (int n : preCourses) {
            if (n > 0) {
                return false;
            }
        }
        return true;
    }

    private void bfs(Queue<Integer> queue, int[][] graph, int[] preCourses) {
        while (queue.size() > 0) {
            int e = queue.remove();
            for (int i = 0; i < graph.length; i++) {
                if (graph[e][i] == 1) {
                    preCourses[i]--;
                    if (preCourses[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

    }

}
