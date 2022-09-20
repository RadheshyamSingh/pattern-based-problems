package com.radhe.twopointers;

/**
 * Given an array of sorted numbers, remove all duplicate number instances from it in-place, such that each element appears only once. The relative order of the elements should be kept the same and you should not use any extra space so that that the solution have a space complexity of O(1).
 * <p>
 * Move all the unique elements at the beginning of the array and after moving return the length of the subarray that has no duplicate in it.
 * <p>
 * Example 1:
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 * <p>
 * Example 2:
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2, 11].
 */
public class RemoveDuplicates {
    public static int remove(int[] arr) {
        if (null == arr || arr.length == 0) {
            return -1;
        }

        int slow = 0;
        int fast = 1;

        while (fast < arr.length) {
            if (arr[slow] != arr[fast]) {
                arr[++slow] = arr[fast];
            }

            fast++;
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[]{2, 2, 2, 11};
        System.out.println(RemoveDuplicates.remove(arr));
    }
}
