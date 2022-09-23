package com.radhe.twopointers;

/**
 * Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
 * <p>
 * Example 1:
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 * <p>
 * Example 2:
 * Input: [1, 3, 2, 0, -1, 7, 10]
 * Output: 5
 * Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 * <p>
 * Example 3:
 * Input: [1, 2, 3]
 * Output: 0
 * Explanation: The array is already sorted
 * <p>
 * Example 4:
 * Input: [3, 2, 1]
 * Output: 3
 * Explanation: The whole array needs to be sorted.
 */
public class MinimumWindowSort {

    public int findUnsortedSubarray(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        // find the left index where sorting differs i.e. where nums[left] > nums[left + 1]
        while (left < nums.length - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        // to handle case if array is already sorted
        if (left == right) {
            return 0;
        }

        // find the right index where sorting differs i.e. where nums[right] < nums[right - 1]
        while (nums[right] >= nums[right - 1]) {
            right--;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        /// find min and max between left and right
        for (int index = left; index <= right; index++) {
            min = Math.min(min, nums[index]);
            max = Math.max(max, nums[index]);
        }

        /// check for part < left
        for (int index = 0; index <= left; index++) {
            if (nums[index] > min) {
                left = index;
                break;
            }
        }

        /// check for part > right
        for (int index = nums.length - 1; index >= right; index--) {
            if (nums[index] < max) {
                right = index;
                break;
            }
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        final MinimumWindowSort obj = new MinimumWindowSort();
        System.out.println(obj.findUnsortedSubarray(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(obj.findUnsortedSubarray(new int[]{1, 3, 2, 0, -1, 7, 10}));
        System.out.println(obj.findUnsortedSubarray(new int[]{1, 2, 3}));
        System.out.println(obj.findUnsortedSubarray(new int[]{3, 2, 1}));
    }
}
