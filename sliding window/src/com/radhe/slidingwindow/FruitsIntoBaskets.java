package com.radhe.slidingwindow;

import java.util.HashMap;

/**
 * You are visiting a farm to collect fruits. The farm has a single row of fruit trees. You will be given two baskets, and your goal is to pick as many fruits as possible to be placed in the given baskets.
 * You will be given an array of characters where each character represents a fruit tree. The farm has following restrictions:
 * Each basket can have only one type of fruit. There is no limit to how many fruit a basket can hold.
 * You can start with any tree, but you can’t skip a tree once you have started.
 * You will pick exactly one fruit from every tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 * Write a function to return the maximum number of fruits in both baskets.
 * <p>
 * Example 1:
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 * <p>
 * Example 2:
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
public class FruitsIntoBaskets {

    public int findLength(char[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }

        if (arr.length <= 2) {
            return arr.length;
        }

        int windowStart = 0;
        int maxLength = 0;
        final HashMap<Character, Integer> charMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            final char ch = arr[windowEnd];
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);

            /// shrink the window
            while (charMap.size() > 2) {
                char charToRemove = arr[windowStart];
                charMap.put(charToRemove, charMap.getOrDefault(charToRemove, 0) - 1);
                if (charMap.get(charToRemove) == 0) {
                    charMap.remove(charToRemove);
                }

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        final FruitsIntoBaskets obj = new FruitsIntoBaskets();
        int maxLength = obj.findLength(new char[]{'A', 'B', 'C', 'A', 'C'});
        System.out.println("MaxLength is : " + maxLength);
        maxLength = obj.findLength(null);
        System.out.println("MaxLength is : " + maxLength);
        maxLength = obj.findLength(new char[]{});
        System.out.println("MaxLength is : " + maxLength);
        maxLength = obj.findLength(new char[]{'A', 'B'});
        System.out.println("MaxLength is : " + maxLength);
    }
}
