package dp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WildcardMatching {

    /**
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     */
    static Boolean[][] cache;
    // TODO add cache
    public static boolean isMatch(String s, String p) {

        cache = new Boolean[s.length()][p.length()];

        return helper(s, p);
    }

    private static boolean helper(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();

        if (!s.isEmpty()) {
            if (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) {
                return helper(s.substring(1), p.substring(1));
            } else if (p.charAt(0) == '*') {
                return helper(s.substring(1), p)
                        || helper(s.substring(1), p.substring(1));
            }
        } else {
            return p.charAt(0) == '*' && helper(s, p.substring(1));
        }
        return false;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
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
        System.out.println("All succeed. " + (System.currentTimeMillis() - startTime));
    }
}
