package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-04 20:07
 * 思路： 设G(n)为含有n个结点的二叉搜索树，则当以i = 1,2,3...n为根结点时，
 *      其左子树有i-1个结点，右子树有n-i个结点，因此有递推式如下：
 *      G(n) += G(i-1)*G(n-i), 1<=i<=n
 **/
public class NumTrees {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        //有i个结点的树
        for (int i = 1; i < num.length; i++) {
            //以j为根的结点
            for (int j = 1; j <= i; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }
}
