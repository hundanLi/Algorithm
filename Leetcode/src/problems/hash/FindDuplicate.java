package problems.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-23 00:05
 **/
public class FindDuplicate {
    public List<List<String>> findDuplicate(String[] paths) {
        // 文件内容 -> 路径列表
        Map<String, List<String>> map = new HashMap<>(16);
        for (String path : paths) {
            String[] split = path.split(" ");
            String dir = split[0];
            for (int i = 1; i < split.length; i++) {
                String file = split[i];
                String filename = file.substring(0, file.indexOf('('));
                String content = file.substring(file.indexOf('('), file.length() - 1);
                List<String> list = map.computeIfAbsent(content, k -> new ArrayList<>());
                list.add(dir + "/" + filename);
            }
        }
        List<List<String>> lists = new ArrayList<>(map.size());
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                lists.add(list);
            }
        }
        return lists;
    }
}
