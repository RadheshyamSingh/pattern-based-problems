package com.radhe.twopointers;

import java.util.Arrays;

/**
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 * <p>
 * The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.
 * <p>
 * Example 1:
 * Input: [1, 0, 2, 1, 0]
 * Output: [0, 0, 1, 1, 2]
 * <p>
 * Example 2:
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0, 0, 1, 2, 2, 2,]
 */
public class DutchNationalFlagProblem {
    public void sortColors(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }

        int left = 0;
        int right = arr.length - 1;

        for (int index = 0; index <= right; ) {
            if (arr[index] == 0) {
                swap(index, left, arr);
                left++;
                index++;
            } else if (arr[index] == 2) {
                swap(index, right, arr);
                right--;
            } else {
                index++;
            }
        }
    }

    void swap(int first, int second, int[] arr) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        final DutchNationalFlagProblem dutchFlag = new DutchNationalFlagProblem();
        int[] arr = new int[]{1, 0, 2, 1, 0};
        dutchFlag.sortColors(arr);
        System.out.print(Arrays.toString(arr));

        System.out.println();

        arr = new int[]{2, 2, 0, 1, 2, 0};
        dutchFlag.sortColors(arr);
        System.out.print(Arrays.toString(arr));

        System.out.println();
        arr = new int[]{2, 0, 2, 1, 1, 0};
        dutchFlag.sortColors(arr);
        System.out.print(Arrays.toString(arr));

        System.out.println();
        arr = new int[]{2, 0, 1};
        dutchFlag.sortColors(arr);
        System.out.print(Arrays.toString(arr));

        System.out.println();
        arr = new int[]{2, 0};
        dutchFlag.sortColors(arr);
        System.out.print(Arrays.toString(arr));


    }
}
