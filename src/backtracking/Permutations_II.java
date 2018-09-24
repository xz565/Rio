package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaodz on 6/18/17.
 *
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 */
public class Permutations_II {

    // follow up for Permutations
    // [1,1,2] -> [1,1,2],[1,2,1],[2,1,1]
    // The idea is, if current value is the same as previous one, we can skip
    public static List<List<Integer>> permuteUnique(int[] nums) {
        // dfs, back tracking
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) return results;
        List<Integer> curList = new ArrayList<>();
        Arrays.sort(nums); // sort is cheating!!!
        dfs(nums, new boolean[nums.length], curList, results);
        return results;
    }

    private static void dfs(int[] nums, boolean[] used, List<Integer> curList, List<List<Integer>> results) {
        if (curList.size() == nums.length) {
            results.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < nums.length; i++) if (!used[i]) {
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1])
                continue;

            curList.add(nums[i]);
            used[i] = true;
            dfs(nums, used, curList, results);
            curList.remove(curList.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[] {1,1,2}));
        System.out.println(permuteUnique(new int[] {1,1,2,1}));
    }

    // TODO what is sort is not allowed
}
