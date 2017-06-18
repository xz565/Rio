package subarray;

/**
 * Created by xiaodz on 5/29/17.
 */
public class Candy_135 {

    public static int candy(int[] ratings) {
        // scan from left -> right
        // scan from right -> left
        // [1,2,3,4,5,3,2,1]
        //  1,2,3,4,5,1,1,1
        //  1 2 3 4 5 3 2 1
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1] + 1;
            } else {
                candy[i] = 1;
            }
        }

        int sum = candy[ratings.length-1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]) {
                candy[i] = candy[i+1] + 1;
            }
            sum += candy[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] rating = {1,2,3,4,5,3,2,1};
        System.out.println(candy(rating));
    }
}
