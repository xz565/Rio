package company.fb;

import static org.junit.Assert.assertEquals;

public class DecodeWays_91 {

    static Integer[] cache;
    public static int numDecodings(String s) {

        cache = new Integer[s.length() + 1];
        helper(s, 0);

        return cache[0] == null ? 0 : cache[0];
    }

    private static int helper(String s, int pos) {

        if (cache[pos] != null) {
            return cache[pos];
        }

        if (s.length() - pos < 1) {
            return 1;
        }

//        int rst = numDecodings(s.substring(1));

        int rst = 0;
        if (s.charAt(pos) != '0') {
            rst += helper(s, pos + 1);
            if (s.length() - pos >= 2
                    && Integer.valueOf(s.substring(pos, pos + 2)) <= 26) {
//            rst += numDecodings(s.substring(2));
                rst += helper(s, pos + 2);
            }
        }

        cache[pos] = rst;

        return rst;
    }

    public static void main(String[] args) {

        assertEquals(0, numDecodings(""));
        assertEquals(1, numDecodings("1"));
        assertEquals(2, numDecodings("12"));
        assertEquals(3, numDecodings("123"));
        assertEquals(1, numDecodings("101"));
        assertEquals(3, numDecodings("10123"));
    }
}
