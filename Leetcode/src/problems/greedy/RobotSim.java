package problems.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-19 10:02
 **/
public class RobotSim {
    static class Tuple {
        int x;
        int y;

        Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Tuple)) {
                return false;
            }

            Tuple tuple = (Tuple) o;

            if (x != tuple.x) {
                return false;
            }
            return y == tuple.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || commands.length == 0) {
            return 0;
        }
        Set<Tuple> tuples = new HashSet<>();
        for (int[] obs : obstacles) {
            tuples.add(new Tuple(obs[0], obs[1]));
        }
        int[] up = {0, 1};
        int[] down = {0, -1};
        int[] left = {-1, 0};
        int[] right = {1, 0};
        int[] step = up;
        int[] cur = {0, 0};
        int maxDistance = 0;
        for (int c : commands) {
            int[] temp;
            if (c > 0) {
                while (c > 0) {
                    temp = forward(cur, step);
                    if (!tuples.contains(new Tuple(temp[0], temp[1]))) {
                        cur = temp;
                    } else {
                        break;
                    }
                    c--;
                }
            } else {
                if (c == -1) {
                    if (step == up) {
                        step = right;
                    } else if (step == right) {
                        step = down;
                    } else if (step == down) {
                        step = left;
                    } else {
                        step = up;
                    }
                } else if (c == -2) {
                    if (step == up) {
                        step = left;
                    } else if (step == left) {
                        step = down;
                    } else if (step == down) {
                        step = right;
                    } else {
                        step = up;
                    }
                }
            }
            maxDistance = Math.max(maxDistance, cur[0] * cur[0] + cur[1] * cur[1]);
        }
        return maxDistance;
    }

    private static int[] forward(int[] cur, int[] step) {
        int[] next = {0, 0};
        next[0] = cur[0] + step[0];
        next[1] = cur[1] + step[1];
        return next;
    }

    public static void main(String[] args) {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obs = {{2, 4}};
        int sim = robotSim(commands, obs);
        System.out.println(sim);

    }


}
