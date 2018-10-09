package company.gg;

import java.util.Arrays;

public class SortColors_75 {

    public static void sortColors(int[] nums) {
        int first = 0;
        int second = nums.length - 1;
        for (int i = 0; i <= second; i++) {
            if (nums[i] == 0) {
                // swap with first
                swap(nums, i, first++);
            } else if (nums[i] == 2) {
                // swap with second
                swap(nums, i--, second--);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = new int[] {1,2,0};
        sortColors(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
