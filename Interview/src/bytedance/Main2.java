package bytedance;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-14 10:58
 **/
public class Main2 {
    static class Tuple{
        int x;
        int y;

        public Tuple(int x, int y) {
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
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Tuple> curFrame;
        Map<Tuple, Integer> frameMove = new HashMap<>(16);
        int[] ints = new int[2];
        int max;
        int n = in.nextInt();
        //n个用例
        for (int i = 0; i < n; i++) {
            max = 0;
            int m = in.nextInt();
            //m帧
            for (int j = 0; j < m; j++) {
                curFrame = new HashSet<>();
                int num = in.nextInt();
                //num个特征
                for (int k = 0; k < num; k++) {
                    ints[0] = in.nextInt();
                    ints[1] = in.nextInt();
                    Tuple tuple = new Tuple(ints[0], ints[1]);
                    curFrame.add(tuple);
                    frameMove.put(tuple, frameMove.getOrDefault(tuple, 0) + 1);
                    max = Math.max(max, frameMove.get(tuple));
                }
                //将不连续的特征清零
                for (Tuple tuple : frameMove.keySet()) {
                    if (!curFrame.contains(tuple)) {
                        frameMove.put(tuple, 0);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
