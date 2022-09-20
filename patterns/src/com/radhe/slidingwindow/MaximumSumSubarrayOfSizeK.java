package com.radhe.slidingwindow;

/**
 * Problem:
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 * <p>
 * Example 1:
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * <p>
 * Example 2:
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaximumSumSubarrayOfSizeK {

    void findMaxSumSubArray(int[] arr, int windowSize) {
        int maxWindowSum = 0;
        int currentWindowSum = 0;

        if (arr.length < windowSize) {
            System.out.println("Invalid array size");
            return;
        }

        for (int index = 0; index < arr.length; index++) {
            if (index < windowSize) {
                currentWindowSum += arr[index];
                maxWindowSum = currentWindowSum;
            } else {
                currentWindowSum = currentWindowSum - arr[index - windowSize] + arr[index];

                if (currentWindowSum > maxWindowSum) {
                    maxWindowSum = currentWindowSum;
                }
            }
        }

        System.out.println("Maximum sum is : " + maxWindowSum);
    }

    public static void main() {
        final int[] inputArray = {2, 1, 5, 1, 3, 2};
        final int size = 3;
        final MaximumSumSubarrayOfSizeK maximumSumSubarrayOfSizeK = new MaximumSumSubarrayOfSizeK();
        maximumSumSubarrayOfSizeK.findMaxSumSubArray(inputArray, size);
    }

}
