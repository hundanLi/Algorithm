package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-12 10:35
 **/
public class FindMaximumXOR {

    static class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        int maxNum = 0;
        for (int n : nums) {
            maxNum = Math.max(maxNum, n);
        }
        int len = Integer.toBinaryString(maxNum).length();
        int bitmask = 1 << len;
        String[] binaryStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            binaryStrings[i] = Integer.toBinaryString(nums[i] | bitmask).substring(1);
        }

        TrieNode root = new TrieNode();
        int maxXor = 0;
        for (String bin : binaryStrings) {
            TrieNode node = root;
            TrieNode xorNode = root;
            int curXor = 0;
            for (char bit : bin.toCharArray()) {
                // 插入新数字
                int idx = bit - '0';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];

                // 计算该数字与此前插入的数字的最大xor
                if (xorNode.children[1 - idx] != null) {
                    curXor = (curXor << 1) + 1;
                    xorNode = xorNode.children[1 - idx];
                } else {
                    curXor = curXor << 1;
                    xorNode = xorNode.children[idx];
                }
            }
            maxXor = Math.max(maxXor, curXor);
        }
        return maxXor;
    }
}
