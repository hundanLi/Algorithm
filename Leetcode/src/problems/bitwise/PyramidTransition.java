package problems.bitwise;

import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-12 23:26
 * 'ABCDEFG' 任意三个组合可以使用一个字节的二进制数字表示，如 'ABD' = 00001011
 **/
public class PyramidTransition {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // 底层的节点集合
        int[] layer = new int[bottom.length()];
        for (int i = 0; i < layer.length; i++) {
            layer[i] = 1 << bottom.charAt(i) - 'A';
        }
        // map[i][i+1] 表示对应的上一层字母集合
        int[][] map = new int[8][8];
        for (String s : allowed) {
            int x = s.charAt(0) - 'A';
            int y = s.charAt(1) - 'A';
            map[x][y] |= 1 << s.charAt(2) - 'A';
        }

        // bfs
        while (layer.length > 1) {
            int[] upperLayer = new int[layer.length - 1];
            for (int i = 0; i < upperLayer.length; i++) {
                for (int j = 0; j < 8 ; j++) {
                    if ((layer[i] & (1 << j)) != 0) {
                        for (int k = 0; k < 8; k++) {
                            if ((layer[i + 1] & (1 << k)) != 0) {
                                upperLayer[i] |= map[j][k];
                            }
                        }
                    }
                }
                if (upperLayer[i] == 0) {
                    return false;
                }
            }
            layer = upperLayer;
        }

        return true;
    }
}
