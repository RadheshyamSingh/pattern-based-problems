package com.radhe.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 * <p>
 * Example 1:
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 * <p>
 * Example 2:
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 */
public class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        /// check boundary conditions
        if (null == nums || nums.length == 0) {
            return triplets;
        }

        /// sort array
        Arrays.sort(nums);
        System.out.println("sorted array is ");
        for (int index = 0; index < nums.length; index++) {
            System.out.print(" " + nums[index] + ",");
        }

        /// find the target sum for triplets
        int lastSelected = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            if (lastSelected != nums[index]) {
                int newTarget = -nums[index];
                int left = index + 1;
                int right = nums.length - 1;
                int lastLeft = Integer.MIN_VALUE;
                int lastRight = Integer.MAX_VALUE;
                List<Integer> list;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == newTarget) {
                        if (lastLeft != nums[left] || lastRight != nums[right]) {
                            list = new ArrayList<>();
                            lastLeft = nums[left];
                            lastRight = nums[right];
                            list.add(nums[index]);
                            list.add(nums[left]);
                            list.add(nums[right]);
                            triplets.add(list);
                        }
                        left++;
                        right--;
                    } else if (sum > newTarget) {
                        right--;
                    } else {
                        left++;
                    }
                }
                lastSelected = nums[index];
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }
}
