package com.radhe.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.
 * <p>
 * Example 1:
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 * <p>
 * Example 2:
 * Input: [2, 0, -1, 1, -2, 2], target=2
 * Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 */
public class QuadrupleSumToTarget {

    public List<List<Integer>> searchQuadruplets(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // boundaries condition
        if (null == nums || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int fIndex = 0; fIndex < nums.length - 3; fIndex++) {
            // continue in case of same number
            if (fIndex > 0 && nums[fIndex] == nums[fIndex - 1]) {
                continue;
            }
            for (int sIndex = fIndex + 1; sIndex < nums.length - 2; sIndex++) {
                // continue in case of same number
                if (sIndex > fIndex + 1 && nums[sIndex] == nums[sIndex - 1]) {
                    continue;
                }

                long pairTarget = (long) target - nums[fIndex] - nums[sIndex];
                int left = sIndex + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (left > sIndex + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    long pairSum = (long) nums[left] + nums[right];
                    if (pairSum == pairTarget) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[fIndex]);
                        list.add(nums[sIndex]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        right--;
                    } else if (pairSum < pairTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final QuadrupleSumToTarget qst = new QuadrupleSumToTarget();
        System.out.println(qst.searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1));
        System.out.println(qst.searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2));
        System.out.println(qst.searchQuadruplets(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(qst.searchQuadruplets(new int[]{2, 2, 2, 2, 2}, 8));
    }
}
