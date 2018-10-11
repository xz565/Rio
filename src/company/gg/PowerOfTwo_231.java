package company.gg;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PowerOfTwo_231 {
    public static boolean isPowerOfTwo(int n) {

        // 1 -> 1
        // 2 -> 10
        // 3 -> 11
        // 4 -> 100
        // Most significant bit is one, and remaining bits are zero
        if (n <= 0) return false;

        while (n != 0 && n != 1) {
//            if (n % 2 != 0) return false;
            // n & 1 == 1
            if ((n & 1) != 0) return false;
            n = n >> 1;
        }
        return true;
    }

    public static void main(String[] args) {
        assertTrue(isPowerOfTwo(1));
        assertTrue(isPowerOfTwo(2));
        assertFalse(isPowerOfTwo(3));
        assertTrue(isPowerOfTwo(4));
        assertFalse(isPowerOfTwo(5));
        assertFalse(isPowerOfTwo(6));
        assertTrue(isPowerOfTwo(8));
    }
}
