package problems.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-23 12:50
 **/
public class Codec {
    private Map<Integer, String> map = new HashMap<>();
    private int idx = 0;
    private static final String PREFIX = "http://tinyurl.com/";
    public String encode(String longUrl) {
        map.put(idx, longUrl);
        return PREFIX + idx++;
    }

    public String decode(String shortUrl) {
        int i = Integer.parseInt(shortUrl.substring(PREFIX.length()));
        return map.get(i);
    }
}
