package subarray;

import java.util.HashMap;

public class SubarraySumEqualsK_560 {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSumCnt = new HashMap<Integer, Integer>(){
            {
                put(0, 1);
            }
        };
        preSumCnt.put(0, 1);
        int cnt = 0;
        int runningSum = 0;
        for (int n : nums) {
            runningSum += n;
            cnt += preSumCnt.getOrDefault(runningSum - k, 0);
            preSumCnt.put(runningSum, preSumCnt.getOrDefault(runningSum, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, -1, 1};
        System.out.println(subarraySum(nums, 2));
        System.out.println(subarraySum(nums, 3));
    }
}
