package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums,
 * return all possible subsets (the power set).
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        dfs(nums, new ArrayList<>(), 0, rst);
        return rst;
    }

    private static void dfs(int[] nums, List<Integer> curtList, int curtPos, List<List<Integer>> rst) {
        rst.add(new ArrayList<>(curtList));
        if (curtPos >= nums.length) {
            return;
        }
        for (int i = curtPos; i < nums.length; i++) {
            curtList.add(nums[i]);
            dfs(nums, curtList, i + 1, rst);
            curtList.remove(curtList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[] {}));
        System.out.println(subsets(new int[] {1}));
        System.out.println(subsets(new int[] {1,2,3}));
    }
}
