package com.radhe.twopointers;

/**
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 * <p>
 * Example 1:
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 * <p>
 * Example 2:
 * Input: str1="xy#z", str2="xyz#"
 * Output: false
 * Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
 * <p>
 * Example 3:
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 * <p>
 * Example 4:
 * Input: str1="xywrrmp", str2="xywrrmu#p"
 * Output: true
 * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 */
public class ComparingStringsContainingBackspaces {
    public boolean backspaceCompare(String first, String second) {
        if (null == first || null == second) {
            return false;
        }

        int fLength = first.length() - 1;
        int sLength = second.length() - 1;
        char bsp = '#';

        while (fLength >= 0 || sLength >= 0) {

            // handle backspace for first string
            int bspCount = 0;
            while (fLength >= 0 && first.charAt(fLength) == bsp) {
                fLength--;
                bspCount++;
            }

            fLength -= bspCount;

            // handle backspace for second string
            bspCount = 0;
            while (sLength >= 0 && second.charAt(sLength) == bsp) {
                sLength--;
                bspCount++;
            }

            sLength -= bspCount;

            if ((fLength >= 0 && first.charAt(fLength) == bsp) || (sLength >= 0 && second.charAt(sLength) == bsp)) {
                continue;
            }

            if (fLength >= 0 && sLength >= 0) {
                if (first.charAt(fLength) != second.charAt(sLength)) {
                    return false;
                }
                fLength--;
                sLength--;
            } else if (fLength < 0 && sLength < 0) {
                return true;
            }
        }

        if (fLength >= 0 || sLength >= 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        final ComparingStringsContainingBackspaces obj = new ComparingStringsContainingBackspaces();
        System.out.println(obj.backspaceCompare("xy#z", "xzz#"));
        System.out.println(obj.backspaceCompare("xy#z", "xyz#"));
        System.out.println(obj.backspaceCompare("xp#", "xyz##"));
        System.out.println(obj.backspaceCompare("xywrrmp", "xywrrmu#p"));
    }
}
