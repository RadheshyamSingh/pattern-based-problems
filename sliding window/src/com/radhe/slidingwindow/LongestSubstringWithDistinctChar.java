package com.radhe.slidingwindow;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring, which has all distinct characters.
 * <p>
 * Example 1:
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring with distinct characters is "abc".
 * <p>
 * Example 2:
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring with distinct characters is "ab".
 * <p>
 * Example 3:
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings with distinct characters are "abc" & "cde".
 */
public class LongestSubstringWithDistinctChar {
    public int findLength(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }

        int windowStart = 0;
        int maxLength = 0;
        final HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            final char ch = str.charAt(windowEnd);

            while (frequencyMap.getOrDefault(ch, 0) > 0) {
                final char charToRemove = str.charAt(windowStart);
                frequencyMap.put(charToRemove, frequencyMap.get(charToRemove) - 1);
                if (frequencyMap.get(charToRemove) == 0) {
                    frequencyMap.remove(charToRemove);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);

            /// Another approach
            /*char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (frequencyMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, frequencyMap.get(rightChar) + 1);
            }
            frequencyMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far*/
        }

        return maxLength;
    }

    public static void main(String[] args) {
        final LongestSubstringWithDistinctChar obj = new LongestSubstringWithDistinctChar();
        int maxLength = obj.findLength("aabccbb");
        System.out.println("MaxLength is : " + maxLength);
        maxLength = obj.findLength("abbbb");
        System.out.println("MaxLength is : " + maxLength);
        maxLength = obj.findLength("abccde");
        System.out.println("MaxLength is : " + maxLength);
    }
}
