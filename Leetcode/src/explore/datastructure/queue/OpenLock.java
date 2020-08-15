package explore.datastructure.queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-04 10:09
 **/
public class OpenLock {
    public int openLock(String[] deadends, String target) {

        int num = 0;
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if ("0000".equals(target)) {
            return 0;
        }
        if (deadSet.contains("0000")) {
            return -1;
        }

        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int size;
        String e;
        while (!queue.isEmpty()) {
            size = queue.size();
            num++;
            for (int i = 0; i < size; i++) {
                e = queue.remove();
                char[] chars = e.toCharArray();
                for (int j = 0; j < 4; j++) {
                    // subtract 1
                    char[] clone = chars.clone();
                    if (chars[j] == '0') {
                        clone[j] = '9';
                    } else {
                        clone[j] = (char) ((int) clone[j] - 1);
                    }

                    String value = String.valueOf(clone);
                    if (!deadSet.contains(value) && visited.add(value)) {
                        queue.offer(value);
                        if (value.equals(target)) {
                            return num;
                        }
                    }

                    // add 1
                    if (chars[j] < '9') {
                        clone = chars.clone();
                        clone[j] = (char) ((int) clone[j] + 1);
                        value = String.valueOf(clone);
                        if (!deadSet.contains(value) && visited.add(value)) {
                            queue.offer(value);
                            if (value.equals(target)) {
                                return num;
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
}
