package com.radhe.slidingwindow;

import java.util.HashMap;

/**
 * Given a string and a pattern, find the smallest substring in the given string which has all the character occurrences of the given pattern.
 * <p>
 * Example 1:
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 * <p>
 * Example 2:
 * Input: String="aabdec", Pattern="abac"
 * Output: "aabdec"
 * Explanation: The smallest substring having all character occurrences of the pattern is "aabdec"
 * <p>
 * Example 3:
 * Input: String="abdbca", Pattern="abc"
 * Output: "bca"
 * Explanation: The smallest substring having all characters of the pattern is "bca".
 * <p>
 * Example 4:
 * Input: String="adcad", Pattern="abc"
 * Output: ""
 * Explanation: No substring in the given string has all characters of the pattern.
 */
public class SmallestWindowContainingSubstring {

    public String findSubstring(String str, String pattern) {
        if (null == str || null == pattern || pattern.length() > str.length()) {
            return "";
        }

        int windowStart = 0;
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;
        int matchCount = 0;

        final HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch : pattern.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            final char rightChar = str.charAt(windowEnd);
            if (freqMap.containsKey(rightChar)) {
                freqMap.put(rightChar, freqMap.get(rightChar) - 1);
                if (freqMap.get(rightChar) == 0) {
                    matchCount++;
                }
            }

            if (matchCount == freqMap.size()) {
                // shrink window
                while (freqMap.getOrDefault(str.charAt(windowStart), 0) != 0 || !freqMap.containsKey(str.charAt(windowStart))) {
                    char leftChar = str.charAt(windowStart++);
                    if (freqMap.containsKey(leftChar)) {
                        freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                    }
                }

                int currLength = windowEnd - windowStart + 1;
                if (currLength < minLength) {
                    minLength = currLength;
                    startIndex = windowStart;
                }
            }
        }

        if (startIndex >= 0) {
            return str.substring(startIndex, startIndex + minLength);
        }

        return "";
    }

    public static void main() {
        final SmallestWindowContainingSubstring sample = new SmallestWindowContainingSubstring();
        System.out.println("Min length substring: " + sample.findSubstring("aabdec", "abc"));
        System.out.println("Min length substring: " + sample.findSubstring("aabdec", "abac"));
        System.out.println("Min length substring: " + sample.findSubstring("abdbca", "abc"));
        System.out.println("Min length substring: " + sample.findSubstring("adcad", "abc"));
        System.out.println("Min length substring: " + sample.findSubstring("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}
