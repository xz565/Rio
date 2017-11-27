package gg;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/repeated-string-match/description/
 * 686
 */
public class RepeatedStringMatch {

    public static int repeatedStringMatch(String A, String B) {

        StringBuilder sb = new StringBuilder();
        int n = 0;
        while(n < 2 || sb.length() <= B.length()) {
            sb.append(A);
            n++;
            if (sb.toString().contains(B)) {
                return n;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        assertEquals(3, repeatedStringMatch("abcd", "cdabcdab"));
        assertEquals(1, repeatedStringMatch("abcd", "abcd"));
        assertEquals(-1, repeatedStringMatch("abcd", "abcde"));
        assertEquals(2, repeatedStringMatch("abcd", "abcdabcd"));
        assertEquals(2, repeatedStringMatch("ab", "bab"));
        assertEquals(2, repeatedStringMatch("abababaaba", "aabaaba"));
    }
}


