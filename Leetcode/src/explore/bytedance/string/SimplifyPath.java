package explore.bytedance.string;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-08 15:14
 **/
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || "".equals(path.trim())) {
            return null;
        }
        String[] dirs = path.split("/");
        StringBuilder sb = new StringBuilder();
        for (String dir : dirs) {
            if ("".equals(dir.trim())) {
                continue;
            }
            if ("/".equals(dir)) {
                continue;
            }
            if (".".equals(dir)) {
                continue;
            }
            if ("..".equals(dir)) {
                if (sb.length() > 0) {
                    int index = sb.lastIndexOf("/");
                    sb.delete(index, sb.length());
                }
                continue;
            }
            sb.append("/").append(dir);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
