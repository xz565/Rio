package fb.hard;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegularExpressionMatching {

    /*
    isMatch("aa","a") → false
    isMatch("aa","aa") → true
    isMatch("aaa","aa") → false
    isMatch("aa", "a*") → true
    isMatch("aa", ".*") → true
    isMatch("ab", ".*") → true
    isMatch("aab", "c*a*b") → true
    */

    /**
     * Time Complexity ???
     */

    public static boolean isMatch_BF(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstCharMatch = !s.isEmpty()
                && (s.charAt(0) == p.charAt(0) || '.' == p.charAt(0));

        if (p.length() > 1 && '*' == p.charAt(1)) {
            return isMatch_BF(s, p.substring(2))
                    || (firstCharMatch && isMatch_BF(s.substring(1), p));
        } else {
            return firstCharMatch && isMatch_BF(s.substring(1), p.substring(1));
        }
    }

    /**
     *  Add a cache, what does cache[i][j] mean ???
     *  Cache[i][j] means whether s.subString[i] and p.subString[j] match
     *
     */
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
            boolean firstCharMatch = i < s.length()
                && (s.charAt(i) == p.charAt(j) || '.' == p.charAt(j));

            if (j + 1 < p.length()  && '*' == p.charAt(j + 1)) {
                ans = helper(i, j + 2, s, p)
                        || (firstCharMatch && helper(i + 1, j, s, p));
            } else {
                ans = firstCharMatch && helper(i + 1, j + 1, s, p);
            }
        }
        cache[i][j] = ans;
        return ans;
    }


    public static void main(String[] args) {
        assertFalse(isMatch("aa", "a"));
        assertTrue(isMatch("aa", "aa"));
        assertFalse(isMatch("aaa", "aa"));
        assertTrue(isMatch("aa", "a*"));
        assertTrue(isMatch("aa", "aa*"));
        assertTrue(isMatch("aa", "aaa*"));
        assertTrue(isMatch("aa", "a*a"));
        assertTrue(isMatch("aa", "a*aa"));
        assertFalse(isMatch_BF("ab", ".*c"));
        assertFalse(isMatch("ab", ".*c"));

//        Boolean[] cache = new Boolean[2];
//        System.out.println(cache[0]);
    }
}

