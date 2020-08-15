package mock.month1908;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-03 19:19
 **/
public class EscapePossible {
    static class Tuple {
        int x;
        int y;

        Tuple() {
        }

        Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;

            Tuple tuple = (Tuple) o;

            if (x != tuple.x) return false;
            return y == tuple.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Tuple s = new Tuple(source[0], source[1]);
        Tuple t = new Tuple(target[0], target[1]);
        Set<Tuple> set = new HashSet<>();
        for (int[] ints : blocked) {
            set.add(new Tuple(ints[0], ints[1]));
        }
        return dfs(set, s, t);
    }

    private boolean dfs(Set<Tuple> blocked, Tuple source, Tuple target) {
        if (source.equals(target)) {
            return true;
        }
        if (source.x > 0) {
            source.x -= 1;
            if (!blocked.contains(source)) {
                blocked.add(new Tuple(source.x, source.y));
                if (dfs(blocked, source, target)) {
                    return true;
                }
                blocked.add(new Tuple(source.x, source.y));
            }
            source.x += 1;
        }
        if (source.x < 999999) {
            source.x += 1;
            if (!blocked.contains(source)) {
                blocked.add(new Tuple(source.x, source.y));
                if (dfs(blocked, source, target)) {
                    return true;
                }
                blocked.add(new Tuple(source.x, source.y));
            }
            source.x -= 1;
        }
        if (source.y > 0) {
            source.y -= 1;
            if (!blocked.contains(source)) {
                blocked.add(new Tuple(source.x, source.y));
                if (dfs(blocked, source, target)) {
                    return true;
                }
                blocked.add(new Tuple(source.x, source.y));
            }
            source.y += 1;
        }
        if (source.y < 999999) {
            source.y += 1;
            if (!blocked.contains(source)) {
                blocked.add(new Tuple(source.x, source.y));
                if (dfs(blocked, source, target)) {
                    return true;
                }
                blocked.add(new Tuple(source.x, source.y));
            }
            source.y -= 1;
        }
        return false;
    }

    public static void main(String[] args) {
        EscapePossible ep = new EscapePossible();
        int[][] blocked = new int[][]{{0, 1}, {1, 0}};
        int[] source = {0, 0};
        int[] target = {0, 2};
        System.out.println(ep.isEscapePossible(blocked, source, target));
    }

}
