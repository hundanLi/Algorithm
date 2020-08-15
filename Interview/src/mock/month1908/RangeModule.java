package mock.month1908;


import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-27 09:32
 **/
public class RangeModule {

    private static class Range implements Comparable<Range> {
        int left;
        int right;

        Range(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Range o) {
            if (this.right == o.right) {
                return this.left - o.left;
            }
            return this.right - o.right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Range)) return false;

            Range range = (Range) o;

            if (left != range.left) return false;
            return right == range.right;
        }

        @Override
        public int hashCode() {
            int result = left;
            result = 31 * result + right;
            return result;
        }
    }

    private TreeSet<Range> ranges;

    public RangeModule() {
        ranges = new TreeSet<>();
    }

    public void addRange(int left, int right) {
        Iterator<Range> iterator = ranges.tailSet(new Range(0, left)).iterator();
        Range range;
        while (iterator.hasNext()) {
            range = iterator.next();
            if (right < range.left) {
                break;
            }
            left = Math.min(left, range.left);
            right = Math.max(right, range.right);
            iterator.remove();
        }
        ranges.add(new Range(left, right));
    }

    public boolean queryRange(int left, int right) {
        Range range = ranges.higher(new Range(0, left));
        return range != null && range.left <= left && range.right >= right;
    }

    public void removeRange(int left, int right) {
        Iterator<Range> iterator = ranges.tailSet(new Range(0, left)).iterator();
        Range range;
        ArrayList<Range> todo = new ArrayList<>();
        while (iterator.hasNext()) {
            range = iterator.next();
            if (range.left > right) {
                break;
            }
            if (range.left < left) {
                todo.add(new Range(range.left, left));
            }
            if (range.right > right) {
                todo.add(new Range(right, range.right));
            }
            iterator.remove();
        }
        ranges.addAll(todo);
    }
}
