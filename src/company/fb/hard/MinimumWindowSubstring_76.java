package company.fb.hard;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MinimumWindowSubstring_76 {

//    Given a string S and a string T, find the minimum window in S
//    which will contain all the characters in T in complexity O(n).
//
//    For example,
//    S = "ADOBECODEBANC"
//    T = "ABC"
//    Minimum window is "BANC".

    /**
     * Two pointers + HashTable
     * Does HashSet work ???
     * Left point moves right, remove count
     * Right pointer moves right, add count
     * compare the size of the hashmap to the size of T
     *
     * Question to ask before:
     * Can T contain repeated chars ???
     *
     * Needs a clean logic and careful implementation of details
     */
    public static String minWindow(String s, String t) {
        // Use array here will make it much faster
        // int[] map = new int[256];
        Map<Character, Integer> targetCharMap = createTargetCharMap(t);
        String rst = "";
        int left = 0;
        int right = 0;
        // key to keep track of if window contains the target
        int count = 0;
        Map<Character, Integer> windowMap = new HashMap<>();
        while(right < s.length()) {
            char rightChar = s.charAt(right);
            if (t.indexOf(rightChar) >= 0) {
                windowMap.put(rightChar, windowMap.get(rightChar) == null ? 1 : windowMap.get(rightChar) + 1);

                if (windowMap.get(rightChar) <= targetCharMap.get(rightChar)) {
                    count++;
                }
            }
            right++;
            // move left pointer
            while (count == t.length()) {
                if (rst.isEmpty() || right - left < rst.length()) {
                    rst = s.substring(left, right);
                }
                // move left to right
                char leftChar = s.charAt(left);
                if (t.indexOf(leftChar) >= 0) {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                    if (windowMap.get(leftChar) < targetCharMap.get(leftChar)) {
                        count--;
                    }
                }
                left++;
            }

        }
        return rst;
    }

    private static Map<Character,Integer> createTargetCharMap(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char a : t.toCharArray()) {
            map.put(a, map.get(a) == null ? 1 : map.get(a) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("A", minWindow("A", "A"));
        assertEquals("b", minWindow("ab", "b"));
        assertEquals("aa", minWindow("aa", "aa"));
    }
}
