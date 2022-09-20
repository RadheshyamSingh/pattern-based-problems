package com.radhe.slidingwindow;

/**
 * Problem:
 * Given an array of positive integers and a number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 * <p>
 * Example 1:
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to ‘7’ is [5, 2].
 * <p>
 * Example 2:
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to ‘7’ is [8].
 * <p>
 * Example 3:
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to ‘8’ are [3, 4, 1] or [1, 1, 6].
 */

public class SmallestSubarrayWithAGreaterSum {

    public void findMaxSumSubArray(int desiredSum, int[] inputArray) {
        if (inputArray.length == 0) {
            System.out.println("Empty input array");
        }

        int smallestSize = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowStartIndex = 0;

        for (int index = 0; index < inputArray.length; index++) {
            windowSum += inputArray[index];

            while (windowSum >= desiredSum) {
                int currentWindowSize = index - windowStartIndex + 1;

                if (currentWindowSize < smallestSize) {
                    smallestSize = currentWindowSize;
                }

                windowSum -= inputArray[windowStartIndex];
                windowStartIndex++;
            }
        }

        System.out.println("Smallest sub array size : " + smallestSize);
    }

    public static void main() {
        final int[] inputArray = {2, 1, 5, 2, 3, 2};
        final int size = 7;
        final MaximumSumSubarrayOfSizeK maximumSumSubarrayOfSizeK = new MaximumSumSubarrayOfSizeK();
        maximumSumSubarrayOfSizeK.findMaxSumSubArray(size, inputArray);
    }
}
