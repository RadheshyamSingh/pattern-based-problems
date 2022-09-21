package com.radhe.twopointers;

import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.
 * <p>
 * Example 1:
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 * <p>
 * Example 2:
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target:
 * [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
public class TripletsWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        int count = -1;
        if (null == arr || arr.length < 3) {
            return count;
        }

        // sort array
        Arrays.sort(arr);

        count = 0;
        for (int index = 0; index < arr.length - 1; index++) {
            int left = index + 1;
            int right = arr.length - 1;
            int newTarget = target - arr[index];
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum < newTarget) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletsWithSmallerSum.searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(TripletsWithSmallerSum.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}
