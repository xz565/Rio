package company.fb;

public class HammingDistance_461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }
}
