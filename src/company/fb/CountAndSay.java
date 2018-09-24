package company.fb;

public class CountAndSay {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prevString = countAndSay(n - 1);
        char curtVal = prevString.charAt(0);
        int curtCnt = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : prevString.toCharArray()) {
            if (curtVal == ch) {
                curtCnt++;
            } else {
                sb.append(curtCnt).append(curtVal);
                curtVal = ch;
                curtCnt = 1;
            }
        }
        sb.append(curtCnt).append(curtVal);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
    }
}
