package company.gg;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation_320 {

    public static List<String> generateAbbreviations(String word) {
        List<String> rst = new ArrayList<>();
        if ("".equals(word)) {
            rst.add("");
            return rst;
        }
        dfs(word.toCharArray(), rst, new StringBuilder(), 0);
        return rst;
    }

    private static void dfs(char[] chars, List<String> rst, StringBuilder sb, int i) {
        if (i >= chars.length) {
            return;
        }

        int num = 0;
        int sbLen = sb.length();
        for (int j = i; j <= chars.length; j++) {

            sb.append(num == 0 ? "" : num);
            sb.append(j >= chars.length ? "" : chars[j]);

            if (j >= chars.length - 1) {
                rst.add(sb.toString());
            }

            dfs(chars, rst, sb, j+1);

            sb.setLength(sbLen);
            num++;
        }
    }


    public static void main(String[] args) {

        System.out.println(generateAbbreviations(""));
        System.out.println(generateAbbreviations("w"));
        System.out.println(generateAbbreviations("word"));
    }
}
