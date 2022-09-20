package com.radhe.twopointers;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 * <p>
 * Example 1:
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 * <p>
 * Example 2:
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 */
public class SquaringSortedArray {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        if (arr.length == 0) {
            return squares;
        }

        int maxNegativeNumberIndex = 0;

        while (maxNegativeNumberIndex < arr.length && arr[maxNegativeNumberIndex] <= 0) {
            maxNegativeNumberIndex++;
        }

        int left = maxNegativeNumberIndex - 1;
        int right = maxNegativeNumberIndex;
        int index = 0;

        while (left >= 0 && right < arr.length) {
            if (Math.abs(arr[left]) <= Math.abs(arr[right])) {
                squares[index++] = arr[left] * arr[left];
                left--;
            } else {
                squares[index++] = arr[right] * arr[right];
                right++;
            }
        }

        if (left < 0 && right < arr.length) {
            while (right < arr.length) {
                squares[index++] = arr[right] * arr[right];
                right++;
            }
        }

        if (left >= 0 && right >= arr.length) {
            while (left >= 0) {
                squares[index++] = arr[left] * arr[left];
                left--;
            }
        }

        return squares;
    }

    public static void main(String[] args) {

        int[] result = SquaringSortedArray.makeSquares(new int[]{-2, -1, 0, 2, 3});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SquaringSortedArray.makeSquares(new int[]{-3, -1, 0, 1, 2});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
