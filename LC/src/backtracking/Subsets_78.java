package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    // DFS back tracking
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        helper(rst, tempList, nums, 0);
        return rst;
    }

    private static void helper(List<List<Integer>> rst, List<Integer> tempList, int[] nums, int curt) {
        rst.add(new ArrayList<>(tempList));
        for (int i = curt; i < nums.length; i++) {
            tempList.add(nums[i]);
            helper(rst, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3,4,5}));
    }
}
