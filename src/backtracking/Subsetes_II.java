package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaodz on 6/18/17.
 * Given a collection of integers that might contain duplicates, nums,
 * return all possible subsets (the power set).
 */
public class Subsetes_II {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), new boolean[nums.length], 0, rst);
        return  rst;
    }

    private static void dfs(int[] nums, List<Integer> curtList, boolean[] used,
                            int curtPos, List<List<Integer>> rst) {
        rst.add(new ArrayList<>(curtList));
        if (curtPos >= nums.length) return;

        for (int i = curtPos; i < nums.length; i++)
            if (i == 0 || used[i - 1] || nums[i] != nums[i - 1]) {
            curtList.add(nums[i]);
            used[i] = true;
            dfs(nums, curtList, used, i + 1, rst);
            curtList.remove(curtList.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {}));
        System.out.println(subsetsWithDup(new int[] {1}));
        System.out.println(subsetsWithDup(new int[] {1,1}));
        System.out.println(subsetsWithDup(new int[] {1,1,2}));
        System.out.println(subsetsWithDup(new int[] {1,2,2}));
        System.out.println(subsetsWithDup(new int[] {2,1,2}));
    }
}
