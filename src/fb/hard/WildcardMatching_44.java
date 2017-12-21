package fb.hard;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WildcardMatching_44 {

//    '?' Matches any single character.
//    '*' Matches any sequence of characters (including the empty sequence).
//
//    The matching should cover the entire input string (not partial).
//
//    The function prototype should be:
//    bool isMatch(const char *s, const char *p)
//
//    Some examples:
//    isMatch("aa","a") → false
//    isMatch("aa","aa") → true
//    isMatch("aaa","aa") → false
//    isMatch("aa", "*") → true
//    isMatch("aa", "a*") → true
//    isMatch("ab", "?*") → true
//    isMatch("aab", "c*a*b") → false
    public static boolean isMatch_BF(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstCharMatch = !s.isEmpty()
                && (s.charAt(0) == p.charAt(0) || '?' == p.charAt(0));

        if ('*' == p.charAt(0)) {
            return isMatch_BF(s, p.substring(1))
                    || (!s.isEmpty() && isMatch_BF(s.substring(1), p));
        } else {
            return  firstCharMatch && isMatch_BF(s.substring(1), p.substring(1));
        }
    }


    static Boolean[][] cache;
    public static boolean isMatch(String s, String p) {
        cache = new Boolean[s.length() + 1][p.length() + 1];
        return helper(0, 0, s, p);
    }

    private static boolean helper(int i, int j, String s, String p) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        Boolean ans = false;

        if (j == p.length()) {
            ans = i == s.length();
        } else {
            boolean firstMatch = i < s.length()
                    && (s.charAt(i) == p.charAt(j) || '?' == p.charAt(j));

            if ('*' == p.charAt(j)) {
                ans = helper(i, j + 1, s, p)
                        || (i < s.length() && helper(i + 1, j, s, p));
            } else {
                ans = firstMatch && helper(i + 1, j + 1, s, p);
            }
        }
        cache[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        assertFalse(isMatch("aa", "a"));
        assertTrue(isMatch("aa", "aa"));
        assertFalse(isMatch("aaa", "aa"));
        assertTrue(isMatch("aa", "*"));
        assertTrue(isMatch("aa", "a*"));
        assertTrue(isMatch("aa", "*a"));
        assertFalse(isMatch("aab", "c*a*b"));
        assertFalse(isMatch("zacabz", "*a?b*"));
        assertFalse(isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
                "a*******b"));
    }
}
