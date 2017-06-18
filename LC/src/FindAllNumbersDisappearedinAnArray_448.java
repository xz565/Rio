import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaodz on 5/29/17.
 */
public class FindAllNumbersDisappearedinAnArray_448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        List<Integer> rst = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                rst.add(i+1);
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,2,3,2};
        System.out.println(findDisappearedNumbers(nums));
    }
}
