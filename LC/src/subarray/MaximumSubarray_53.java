package subarray;

/**
 * Created by xiaodz on 5/25/17.
 */
public class MaximumSubarray_53 {

    // O(n), Time out
    public static int maxSubArray_1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int preSumMin = 0;
        int runningSum = 0;

        for (int num : nums) {
            runningSum += num;

            if(runningSum - preSumMin > max)
                max = runningSum - preSumMin;

            if(runningSum < preSumMin)
                preSumMin = runningSum;
        }
        return max;
    }

    public static int maxSubArray(int[] nums) {
        int local = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], nums[i] + local);
            max = Math.max(local, max);
        }
        return max;
    }

    public static void main(String[] args) {
        // test cases
        // {1] {-1} {-2,1,-3,4,-1,2,1,-5,4}
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
