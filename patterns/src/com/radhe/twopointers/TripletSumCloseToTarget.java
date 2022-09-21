package com.radhe.twopointers;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 * <p>
 * Example 1:
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 * <p>
 * Example 2:
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 * <p>
 * Example 3:
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 */
public class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        if (null == arr || arr.length < 3) {
            return -1;
        }

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        int tripletSum = -1;

        //[-2, 0, 1, 2], target=2
        for (int index = 0; index < arr.length - 1; index++) {
            int first = arr[index];
            int left = index + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = first + arr[left] + arr[right];
                int diff = targetSum - sum;
                if (diff == 0) {
                    right--;
                    left++;
                } else if (diff < 0) {
                    right--;
                } else {
                    left++;
                }

                if (diff == minDiff) {
                    tripletSum = Math.min(tripletSum, sum);
                } else if (Math.abs(diff) < Math.abs(minDiff)) {
                    tripletSum = sum;
                    minDiff = diff;
                } else {
                    // NOP
                }
            }
        }

        return tripletSum;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{-2, 0, 1, 2}, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }
}
