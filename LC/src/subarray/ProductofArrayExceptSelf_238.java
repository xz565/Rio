package subarray;

import java.util.Arrays;

public class ProductofArrayExceptSelf_238 {
    public static int[] productExceptSelf(int[] nums) {
        int[] rst = new int[nums.length];
        int[] fwd = new int[nums.length];
        int[] bwd = new int[nums.length];
        fwd[0] = 1;
        bwd[nums.length - 1] = 1;
        // left to right
        for (int i = 1; i < nums.length; i++) {
            fwd[i] = fwd[i-1] * nums[i-1];
        }
        // right to left
        for (int i = nums.length - 2; i >= 0; i--) {
            bwd[i] = bwd[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            rst[i] = fwd[i] * bwd[i];
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        Arrays.stream(productExceptSelf(nums))
                .forEach(n -> System.out.print(n + " "));
    }
}
