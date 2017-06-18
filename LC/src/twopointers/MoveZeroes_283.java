package twopointers;

import java.util.Arrays;

public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[pos++] = num;
            }
        }
        while(pos < nums.length) {
            nums[pos++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 0, 5};
        System.out.println(Arrays.toString(nums));


        Arrays.stream(nums).forEach(System.out::print);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
    }
}
