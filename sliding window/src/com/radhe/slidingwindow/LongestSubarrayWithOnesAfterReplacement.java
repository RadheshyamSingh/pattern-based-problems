package com.radhe.slidingwindow;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
 * <p>
 * Example 1:
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 * <p>
 * Example 2:
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 */
public class LongestSubarrayWithOnesAfterReplacement {

    public int findLength(int[] arr, int k) {
        if (null == arr || arr.length == 0 || k < 0) {
            return 0;
        }

        int windowStart = 0;
        int maxLength = 0;
        int zeroCount = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 0) {
                zeroCount++;
            }

            while (zeroCount > k && windowStart <= windowEnd) {
                if (arr[windowStart] == 0) {
                    zeroCount--;
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        final int[] inputArray = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        final int[] inputArray2 = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        final LongestSubarrayWithOnesAfterReplacement sample = new LongestSubarrayWithOnesAfterReplacement();
        System.out.println("Max Length = " + sample.findLength(inputArray, 2));
        System.out.println("Max Length = " + sample.findLength(inputArray2, 3));
    }
}
