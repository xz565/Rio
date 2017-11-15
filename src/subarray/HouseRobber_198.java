package subarray;

/**
 * Created by xiaodz on 5/25/17.
 */
public class HouseRobber_198 {
    // maxV[i] = max(maxV[i-2]+num[i], maxV[i-1])
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // store previous two max
        int previous = Math.max(nums[0], nums[1]);
        int preTwo = nums[0];
        int max = Math.max(previous, preTwo);
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(preTwo + nums[i], previous);
            preTwo = previous;
            previous = max;
        }
        return max;
    }

    public static void main(String[] args) {
        // {1,2} -> 2
        // {1,2,3} -> 4
        // {2,1,1,2}
        int[] nums = {2,1,1,2};
        System.out.println(rob(nums));
    }
}
