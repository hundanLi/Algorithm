package explore.algorithm.senior.sortsearch;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-27 12:17
 **/
public class FindKthLargest {
    private static Random random = new Random();

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> topk = new PriorityQueue<>(k + 1);
        for (int n : nums) {
            topk.add(n);
            if (topk.size() > k) {
                topk.poll();
            }
        }
        return topk.element();
    }


    public int findKthLargest(int[] nums, int k) {
        return findKth(nums, nums.length - k + 1);
    }


    private int findKth(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot == k - 1) {
                return nums[pivot];
            } else if (pivot > k - 1) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return nums[left];
    }

    private int partition(int[] nums, int start, int end) {
        int index = start + random.nextInt(end - start + 1);
        swap(nums, index, end);
        int pivot = nums[end];
        index = start - 1;
        for (int i = start; i <= end - 1; i++) {
            if (nums[i] < pivot) {
                index++;
                if (index != i) {
                    swap(nums, index, i);
                }
            }
        }
        index++;
        swap(nums, index, end);
        return index;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] ints = new int[]{3, 2, 1, 5, 6, 4};
        int i = findKthLargest.findKthLargest(ints, 2);
        System.out.println(i);
    }
}
