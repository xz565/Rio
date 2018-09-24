package company.fb;

import static org.junit.Assert.assertEquals;

public class ExcelSheetColumnTitle_168 {

    public static String convertToTitle(int n) {
        StringBuilder sb  = new StringBuilder();

        while (n > 0) {
            sb.append((char)('A' + --n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        assertEquals("", convertToTitle(0));
        assertEquals("A", convertToTitle(1));
        assertEquals("Z", convertToTitle(26));
        assertEquals("AA", convertToTitle(27));
        assertEquals("AB", convertToTitle(28));

        assertEquals("BA", convertToTitle(53));
    }
}
