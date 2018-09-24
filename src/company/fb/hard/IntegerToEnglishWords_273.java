package company.fb.hard;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * It is hard to write a concise solution.
 *
 * Didn't come up with an even close to correct solution in the first hour.
 *
 * Can this GAP be filled by more practice ???
 *
 * This is definitely not lacking of knowledge, the best solution to solve this only uses
 * recurision, array, mod and divide. Not even HashMap is needed !!!
 *
 * So this is lacking the ability to apply known knowledge to solve a problem.
 */
public class IntegerToEnglishWords_273 {


    private static final String[] LESS_THEN_20= {"", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private static String[] TENTH = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};

    private static String[] THOUSAND = {"", "Thousand", "Million", "Billion"};

    public static String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();

        int thousandIdx = 0;
        while (num > 0) {
            String word = sb.toString();

        }

        return sb.toString().trim();
    }

    public static String helper(int num) {
        StringBuilder sb = new StringBuilder();

        return sb.toString().trim();
    }


    private static Map<Integer, String> map = new HashMap<>();
    private static Map<Long, String> map2 = new LinkedHashMap<>();

    static {
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninty");

        map2.put(1000000000000L, "Trillion");
        map2.put(1000000000L, "Billion");
        map2.put(1000000L, "Million");
        map2.put(1000L, "Thousand");
    }


    public static String numberToWords_bad(int num) {

        StringBuilder sb = new StringBuilder();

        long remaining = num;
        if (remaining > 0) {
            for (Map.Entry<Long, String> entry : map2.entrySet()) {

                long curt = remaining % entry.getKey();
                if (curt > 0) {
                    sb.append(translateBasic((int) curt))
                            .append(" ").append(entry.getValue());
                    remaining = remaining / entry.getKey();
                }
            }

        } else {
            return "Zero";
        }
        return sb.toString();
    }

    public static String translateBasic(int num) {
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        if (hundred != 0) {
           sb.append(map.get(hundred)).append(" Hundred");
        }

        int remaining = num % 100;
        if (remaining > 0) {
            int ten = remaining / 10;
            if (ten > 0) {
                sb.append(" ").append(map.get(ten * 10));

                remaining = remaining % 10;
                if (remaining > 0) {
                    sb.append(" ").append(map.get(remaining));
                }
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(100));
        System.out.println(numberToWords(999));
        System.out.println(numberToWords(210));
        System.out.println(numberToWords(30));
        System.out.println(numberToWords(55));
    }
}
