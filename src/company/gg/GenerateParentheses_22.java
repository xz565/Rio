package company.gg;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

//    private static Map<Integer, List<String>> cache = new HashMap<>();
//    public static List<String> generateParenthesis(int n) {
//        Set<String> rsts  = new HashSet<>();
//        if (n == 0) return new ArrayList<>();
//        if (n == 1) {
//            rsts.add("()");
//            return new ArrayList<>(rsts);
//        } else {
//            if (!cache.containsKey(n)) {
//                List<String> subRsts = generateParenthesis(n - 1);
//                for (String sub : subRsts) {
//                    rsts.add("()" + sub);
//                    rsts.add("(" + sub + ")");
//                    rsts.add(sub + "()");
//                }
//                cache.put(n, new ArrayList<>(rsts));
//            }
//        }
//        return cache.get(n);
//    }

    public static List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<>();
        StringBuilder curt = new StringBuilder();
        dfs(rst, curt, n, n);
        return rst;
    }

    private static void dfs(List<String> rst, StringBuilder curt, int leftRemain, int rightRemain) {
        if (leftRemain < 0) return;
        if (rightRemain == 0) {
            rst.add(curt.toString());
            return;
        }
        curt.append("(");
        dfs(rst, curt, leftRemain - 1, rightRemain);
        curt.deleteCharAt(curt.length() - 1);
        if (leftRemain < rightRemain) {
            curt.append(")");
            dfs(rst, curt, leftRemain, rightRemain - 1);
            curt.deleteCharAt(curt.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(0));
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(4));
    }
}
