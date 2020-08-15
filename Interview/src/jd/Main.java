package jd;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-13 19:36
 *
 *
 *
 **/
public class Main {
    static class TreeNode {
        int val;
        List<TreeNode> child;

        public TreeNode(int val) {
            this.val = val;
            child = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num == 1) {
            System.out.println(1);
            return;
        }
        int[][] edge = new int[num - 1][2];
        for (int i = 0; i < num - 1; i++) {
            edge[i][0] = in.nextInt();
            edge[i][1] = in.nextInt();
        }
        TreeNode root = buildTree(num, edge);
        int maxChildNum = 1;
        for (TreeNode node : root.child) {
            int n = findNum(node);
            maxChildNum = Math.max(maxChildNum, n);
        }
        System.out.println(maxChildNum);

    }

    private static TreeNode buildTree(int num, int[][] edge) {
        TreeNode[] treeNodes = new TreeNode[num + 1];
        for (int i = 1; i <= num; i++) {
            treeNodes[i] = new TreeNode(i);
        }
        for (int[] e : edge) {
            treeNodes[e[1]].child.add(treeNodes[e[0]]);
        }
        return treeNodes[1];
    }

    private static int findNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int num = 1;
        for (TreeNode node : root.child) {
            num += findNum(node);
        }
        return num;
    }
}
