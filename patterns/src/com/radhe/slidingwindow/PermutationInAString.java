package com.radhe.slidingwindow;

import java.util.HashMap;

/**
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * <p>
 * Example 1:
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 * <p>
 * Example 2:
 * Input: String="odicf", Pattern="dc"
 * Output: false
 * Explanation: No permutation of the pattern is present in the given string as a substring.
 * <p>
 * Example 3:
 * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 * Output: true
 * Explanation: Both the string and the pattern are a permutation of each other.
 * <p>
 * Example 4:
 * Input: String="aaacb", Pattern="abc"
 * Output: true
 * Explanation: The string contains "acb" which is a permutation of the given pattern.
 */
public class PermutationInAString {

    public boolean findPermutation(String str, String pattern) {
        if (null == str || str.length() == 0 || null == pattern || pattern.length() == 0) {
            return false;
        }

        if (pattern.length() > str.length()) {
            return false;
        }

        final HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch : pattern.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int matchCount = 0;
        boolean isFound = false;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            final char currChar = str.charAt(windowEnd);
            if (freqMap.containsKey(currChar)) {
                freqMap.put(currChar, freqMap.get(currChar) - 1);
                if (freqMap.get(currChar) == 0) {
                    matchCount++;
                }
            }

            if (matchCount == freqMap.size()) {
                isFound = true;
                break;
            }

            // shrink window
            if (windowEnd - windowStart >= pattern.length() - 1) {
                final char removeChar = str.charAt(windowStart++);
                if (freqMap.containsKey(removeChar)) {
                    if (freqMap.get(removeChar) == 0) {
                        matchCount--;
                    }
                    freqMap.put(removeChar, freqMap.get(removeChar) + 1);
                }
            }
        }
        return isFound;
    }

    public static void main() {
        final PermutationInAString sample = new PermutationInAString();
        System.out.println("Permutation exist: " + sample.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + sample.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + sample.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + sample.findPermutation("aaacb", "abc"));
        System.out.println("Permutation exist: " + sample.findPermutation("dinitrophenylhydrazinetrinitrophenylmethylnitramine", "trinitrophenylmethylnitramine"));
    }
}
