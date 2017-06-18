package subarray;

public class MaximumProductSubarray_152 {
    public static int maxProduct(int[] nums) {
        int localMin = nums[0];
        int localMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {

            int tempMax = nums[i]*localMax;
            int tempMin = nums[i]*localMin;
            localMax = Math.max(nums[i], Math.max(tempMin, tempMax));
            localMin = Math.min(nums[i], Math.min(tempMin, tempMax));
            max = Math.max(localMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, -3};
        System.out.println(maxProduct(nums));
    }
}
