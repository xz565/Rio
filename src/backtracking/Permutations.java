package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaodz on 6/18/17.
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        // dfs, back tracking
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) return results;
        List<Integer> curList = new ArrayList<>();
        dfs(nums, new boolean[nums.length], curList, results);
        return results;
    }

    private static void dfs(int[] nums, boolean[] added, List<Integer> curList, List<List<Integer>> results) {
        if (curList.size() == nums.length) {
            results.add(new ArrayList<>(curList));
            return;
        }

        for (int i = 0; i < nums.length; i++) if(!added[i]) {
            curList.add(nums[i]);
            added[i] = true;
            dfs(nums, added, curList, results);
            curList.remove(curList.size() - 1);
            added[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[] {1,2,3,4}));
    }
}
