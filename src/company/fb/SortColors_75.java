package company.fb;

import java.util.Arrays;

public class SortColors_75 {

    /**
     * 2,1,3,1,1,3
     *
     * Two poiter
     * @param nums
     */
    public static void sortColors(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        int running = 0;

        // INVARIANT
        while (running <= end) {
            if (nums[running] == 0 && running != start) {
                swap(nums, start++, running--);
            }
            if (nums[running] == 2 && running != end) {
                swap(nums, end--, running--);
            }
            running++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}
