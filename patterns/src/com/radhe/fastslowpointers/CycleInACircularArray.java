package com.radhe.fastslowpointers;

/**
 * We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’ at a particular index. Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices. You should assume that the array is circular which means two things:
 * If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
 * If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
 * Write a method to determine if the array has a cycle. The cycle should have more than one element and should follow one direction which means the cycle should not contain both forward and backward movements.
 * <p>
 * Example 1:
 * Input: [1, 2, -1, 2, 2]
 * Output: true
 * Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0
 * <p>
 * Example 2:
 * Input: [2, 2, -1, 2]
 * Output: true
 * Explanation: The array has a cycle among indices: 1 -> 3 -> 1\
 * <p>
 * Example 3:
 * Input: [2, 1, -1, -2]
 * Output: false
 * Explanation: The array does not have any cycle.
 */
public class CycleInACircularArray {
    public boolean circularArrayLoop(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            int slow = index;
            int fast = index;

            /// check for direction
            boolean isForward = arr[index] > 0;
            while (true) {
                boolean slowDir = arr[slow] > 0;
                boolean fastDir = arr[fast] > 0;

                // check for direction
                if (slowDir != isForward || fastDir != isForward) {
                    break;
                }

                slow = getValidIndex(arr.length + slow + arr[slow], arr.length, slow);
                if (slow == -1) {
                    break;
                }
                fast = getValidIndex(arr.length + fast + arr[fast], arr.length, fast);
                if (fast == -1) {
                    break;
                }

                // check for direction
                fastDir = arr[fast] > 0;

                if (fastDir != isForward) {
                    break;
                }

                fast = getValidIndex(arr.length + fast + arr[fast], arr.length, fast);
                if (fast == -1) {
                    break;
                }

                if (slow == fast) {
                    return true;
                }
            }

        }

        return false;
    }

    int getValidIndex(int sum, int max, int currIndex) {
        int newIndex = sum % max;
        if (sum < 0) {
            newIndex = sum % max + max;
        }

        // check for cycle with single element
        if (newIndex == currIndex) {
            return -1;
        } else {
            return newIndex;
        }
    }

    public static void main(String[] args) {
        final CycleInACircularArray obj = new CycleInACircularArray();
        System.out.println(obj.circularArrayLoop(new int[]{1, 2, -1, 2, 2}));
        System.out.println(obj.circularArrayLoop(new int[]{2, 2, -1, 2}));
        System.out.println(obj.circularArrayLoop(new int[]{2, 1, -1, -2}));
        System.out.println(obj.circularArrayLoop(new int[]{-2, -17, -1, -2, -2}));
        System.out.println(obj.circularArrayLoop(new int[]{1, -2,}));
        System.out.println(obj.circularArrayLoop(new int[]{-1, -2, -3, -4, -5, 6}));
        System.out.println(obj.circularArrayLoop(new int[]{1, -1, 5, 1, 4}));
    }
}
