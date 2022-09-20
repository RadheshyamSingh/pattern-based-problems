package com.radhe.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * Example 1:
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * <p>
 * Example 2:
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * <p>
 * Example 3:
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 * <p>
 * Example 4:
 * Input: String="cbbebi", K=10
 * Output: 6
 * Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".
 */

public class LongestSubstringWithMaximumDistinctChar {
    public int findLength(String str, int k) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        // TODO: Write your code here
        int windowStart = 0;
        int maxLength = 0;
        final Map<Character, Integer> charMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            final char ch = str.charAt(windowEnd);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);

            while (charMap.size() > k) {
                char charToRemove = str.charAt(windowStart);
                charMap.put(charToRemove, charMap.get(charToRemove) - 1);
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
        final String inputStr = "cbbebibibbibbebbee";
        final int k = 10;
        final LongestSubstringWithMaximumDistinctChar myObj = new LongestSubstringWithMaximumDistinctChar();
        final int maxLength = myObj.findLength(inputStr, k);
        System.out.println("Max length is: " + maxLength);
    }

}
