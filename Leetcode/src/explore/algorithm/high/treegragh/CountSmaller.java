package explore.algorithm.high.treegragh;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-25 20:18
 * 思路：归并排序
 **/
public class CountSmaller {

    class BinarySearchTree{
        class Node {
            int val;
            /**
             * 保存已经插入树中的小于等于该节点的结点个数
             */
            int count;
            Node left;
            Node right;

            Node(int val) {
                this.val = val;
                count = 1;
            }
        }

        Node root;

        /**
         * @param key 插入的键值
         * @return  该键值后面比其小的元素个数
         */
        int insert(int key) {
            if (root == null) {
                root = new Node(key);
                return 0;
            }
            int count = 0;
            Node currNode = root;
            while (true) {
                //小于等于当前结点
                if (key <= currNode.val) {
                    currNode.count++;
                    if (currNode.left == null) {
                        currNode.left = new Node(key);
                        break;
                    }
                    currNode = currNode.left;
                } else {
                    count += currNode.count;
                    if (currNode.right == null) {
                        currNode.right = new Node(key);
                        break;
                    }
                    currNode = currNode.right;
                }
            }
            return count;
        }
    }

    public List<Integer> countSmaller(int[] num) {
        if (num == null || num.length == 0) {
            return Collections.emptyList();
        }
        BinarySearchTree bst = new BinarySearchTree();
        List<Integer> list = new ArrayList<>();
        for (int i = num.length - 1; i >= 0; i--) {
            int count = bst.insert(num[i]);
            list.add(count);
        }
        Collections.reverse(list);
        return list;
    }


    private void mergeSort(int[] num, int[] copy, int begin, int end, Map<Integer, Integer> counts) {
        if (begin == end) {
            copy[begin] = num[begin];
            return;
        }
        int mid = (begin + end) / 2;
        mergeSort(copy, num, begin, mid, counts);
        mergeSort(copy, num, mid + 1, end, counts);
        int l = mid;
        int r = end;
        int t = end;
        while (l >= begin && r > mid) {
            if (num[l] > num[r]) {
                counts.put(num[l], counts.getOrDefault(num[l], 0) + r - mid);
                int nl = num[l];
                while (l >= begin && num[l] == nl) {
                    copy[t--] = num[l--];
                }
            } else if (num[l] == num[r]) {
                int count = r - mid;
                int nl = num[l];
                while (l >= begin && num[l] == nl) {
                    copy[t--] = num[l--];
                }
                while (r > mid && num[r] == nl) {
                    copy[t--] = num[r--];
                    count--;
                }
                counts.put(nl, counts.getOrDefault(nl, 0) + count);
            } else {
                int nr = num[r];
                while (r > mid && num[r] == nr) {
                    copy[t--] = num[r--];
                }
            }
        }
        while (r > mid) {
            copy[t--] = num[r--];
        }
        while (l >= begin) {
            copy[t--] = num[l--];
        }

    }

    public static void main(String[] args) {
        int[] num = new int[]{-1,0};
        List<Integer> list = new CountSmaller().countSmaller(num);
        System.out.println(list);
    }
}
