package explore.algorithm.junior.array;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 18-8-12 下午10:02
 **/
public class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] result = new int[list.size()];
        i = 0;
        for (int num : list) {
            result[i++] = num;
        }
        return result;
    }

    /**
     * 使用map
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(nums1.length);
        for (int n : nums2) {
            if (map.getOrDefault(n, 0) > 0) {
                list.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for (int n : list) {
            ans[i++] = n;
        }
        return ans;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2, 2};
        int[] ints = intersection.intersect(num1, num2);
        for (int i : ints) {
            System.out.print(i + " ");
        }

    }
}
