package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k,
 * return all possible combinations of k numbers out of 1 ... n.
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> curtList = new ArrayList<>();

        dfs(1, n, k, curtList, results);

        return results;
    }

    private static void dfs(int startPos, int n, int k, List<Integer> curtList, List<List<Integer>> results) {
        if (curtList.size() == k) {
            results.add(new ArrayList<>(curtList));
            return;
        }

        for (int i = startPos; i <= n; i++) {
            curtList.add(i);
            dfs(i + 1, n, k, curtList, results);
            curtList.remove(curtList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
        System.out.println(combine(2,2));
        System.out.println(combine(1,1));
        System.out.println(combine(0,0));
    }
}
