package problems.stack;


/**
 * @author li
 * @version 1.0
 * @date 2019-11-01 10:48
 **/
public class ValidSerialization {

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        if ("#".equals(nodes[0])) {
            return nodes.length == 1;
        }
        if (preorder.length() < 3) {
            return false;
        }
        int end = getNextRootIdx(nodes, 0);

        return nodes.length == end;
    }

    private int getNextRootIdx(String[] nodes, int root) {
        if (root + 2 < nodes.length) {
            // 存在左子树
            if (!"#".equals(nodes[root + 1])) {
                int rightRootIdx = getNextRootIdx(nodes, root + 1);
                if (rightRootIdx == -1) {
                    return -1;
                }
                // 右子树不存在
                if (rightRootIdx < nodes.length && nodes[rightRootIdx].equals("#")) {
                    return rightRootIdx + 1;
                }
                // 右子树存在
                return getNextRootIdx(nodes, rightRootIdx);
            }
            //左、右子树不存在
            if ("#".equals(nodes[root + 2])) {
                return root + 3;
            }
            // 左子树不存在，右子树存在
            if (!"#".equals(nodes[root + 2])) {
                return getNextRootIdx(nodes, root + 2);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String preorder = "9,#,#,1";
        System.out.println(new ValidSerialization().isValidSerialization(preorder));
    }

    class Solution {
        public boolean isValidSerialization(String preorder) {
            int n = preorder.length();
            int num = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (preorder.charAt(i) == ',') {
                    continue;
                }
                if (preorder.charAt(i) == '#') {
                    num++;
                } else {
                    while (i >= 0 && preorder.charAt(i) != ',') {
                        i--;
                    }
                    if (num >= 2) {
                        num--;
                    } else {
                        return false;
                    }
                }
            }
            return num == 1;
        }
    }
}
