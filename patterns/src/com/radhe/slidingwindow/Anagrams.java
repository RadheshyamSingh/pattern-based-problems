package com.radhe.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 * Every anagram is a permutation of a string. As we know, when we are not allowed to repeat characters while finding permutations of a string, we get N!
 * permutations (or anagrams) of a string having N characters. For example, here are the six anagrams of the string “abc”:
 * <p>
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 * <p>
 * Example 1:
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 * <p>
 * Example 2:
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
public class Anagrams {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();

        if (null == str || null == pattern || pattern.length() > str.length()) {
            return resultIndices;
        }

        int windowStart = 0;
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
                resultIndices.add(windowStart);
            }

            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (freqMap.containsKey(leftChar)) {
                    if (freqMap.get(leftChar) == 0) {
                        matchCount--;
                    }
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                }
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(Anagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(Anagrams.findStringAnagrams("abbcabc", "abc"));
        System.out.println(Anagrams.findStringAnagrams("dinitrophenylhydrazinetrinitrophenylmethylnitramine", "trinitrophenylmethylnitramine"));
    }
}
