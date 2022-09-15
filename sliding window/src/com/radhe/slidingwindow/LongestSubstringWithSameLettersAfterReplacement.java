package com.radhe.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter, find the length of the longest substring having the same letters after replacement.
 * <p>
 * Example 1:
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".
 * <p>
 * Example 2:
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have the longest repeating substring "bbbb".
 * <p>
 * Example 3:
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */

public class LongestSubstringWithSameLettersAfterReplacement {
    public int findLength(String str, int k) {
        if (null == str || str.length() == 0) {
            return 0;
        }

        if (str.length() < k) {
            return str.length();
        }

        int windowStart = 0;
        int maxLength = 0;
        final HashMap<Character, Integer> freqMap = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            final char ch = str.charAt(windowEnd);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            maxHeap.clear();
            maxHeap.addAll(freqMap.entrySet());

            int diffChar = windowEnd - windowStart - maxHeap.poll().getValue() + 1;
            while (diffChar > k) {
                char charToRemove = str.charAt(windowStart);
                freqMap.put(charToRemove, freqMap.getOrDefault(charToRemove, 0) - 1);
                maxHeap.clear();
                maxHeap.addAll(freqMap.entrySet());
                windowStart++;
                diffChar = windowEnd - windowStart - maxHeap.poll().getValue() + 1;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }


    public static void main(String[] args) {
        final LongestSubstringWithSameLettersAfterReplacement mySample = new LongestSubstringWithSameLettersAfterReplacement();
        System.out.println(mySample.findLength("aabccbb", 2));
        System.out.println(mySample.findLength("abbcb", 1));
        System.out.println(mySample.findLength("abccde", 1));
    }
}
