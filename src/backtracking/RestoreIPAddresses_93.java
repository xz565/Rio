package backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses_93 {

    public static List<String> restoreIpAddresses(String s) {
        List<String> rst = new ArrayList<>();
        for (List<String> list : getValidAddress(s, 4)) {
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
               sb.append(str).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            rst.add(sb.toString());
        }
        return rst;
    }


    private static List<List<String>> getValidAddress(String str, int remaingCount) {

        List<List<String>> rst = new ArrayList<>();
        if (remaingCount == 0) {
            if (str.length() == 0) {
                rst.add(new ArrayList<>());
            }
            return rst;
        }

        // stripe 1 bit
        if (str.length() >= 1) {
            for (List<String> list : getValidAddress(str.substring(1, str.length()), remaingCount - 1)) {
                if (list.size() == remaingCount - 1) {
                    list.add(0, str.substring(0, 1));
                    rst.add(list);
                }
            }
        }

        // stripe 2 bits
        if (str.length() >= 2 && str.charAt(0) != '0') {
            for (List<String> list : getValidAddress(str.substring(2, str.length()), remaingCount - 1)) {
                if (list.size() == remaingCount - 1) {
                    list.add(0, str.substring(0, 2));
                    rst.add(list);
                }
            }
        }

        // strip 3 bits
        if (str.length() >= 3 && Integer.valueOf(str.substring(0, 3)) <= 255 && Integer.valueOf(str.substring(0, 3)) >= 100) {
            for (List<String> list : getValidAddress(str.substring(3, str.length()), remaingCount - 1)) {
                if (list.size() == remaingCount - 1) {
                    list.add(0, str.substring(0, 3));
                    rst.add(list);
                }
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("11135"));
        System.out.println(restoreIpAddresses("010010"));
        System.out.println(restoreIpAddresses("101023"));
    }
}
