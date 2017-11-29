package fb;

import static org.junit.Assert.assertEquals;

public class StrStr {
    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        /**
         * < or <=
         */
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean contains = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    contains = false;
                    break;
                }
            }
            if (contains) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        assertEquals(-1, strStr("q", "r"));
        assertEquals(1, strStr("qr", "r"));
        assertEquals(0, strStr("rq", "r"));
    }
}
