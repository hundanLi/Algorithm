package mock.month1907;


/**
 * @author li
 * @version 1.0
 * @date 2019-07-22 10:11
 **/
public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        m--;
        n--;
        while (idx >= 0) {
            if (m < 0) {
                nums1[idx--] = nums2[n--];
            }else if (n < 0) {
                nums1[idx--] = nums1[m--];
            } else if (nums1[m] > nums2[n]) {
                nums1[idx--] = nums1[m--];
            } else {
                nums1[idx--] = nums2[n--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        MergeArray mergeArray = new MergeArray();
        mergeArray.merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
