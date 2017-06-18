package subarray;

public class TrappingRainWater_42 {
    public static int trap(int[] height) {
        if (height.length < 3) return 0;
        // water[n] = Min(leftHigh, rightHigh) - height[n]
        // every point has it's own leftHigh and rightHigh
        // which could be memorized
        int[] leftHigh = new int[height.length];
        int[] rightHigh = new int[height.length];

        leftHigh[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftHigh[i] = Math.max(leftHigh[i-1], height[i-1]);
        }

        rightHigh[height.length-1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightHigh[i] = Math.max(rightHigh[i+1], height[i+1]);
        }

        int sum = 0;
        // this can be optimized
        for(int i = 0; i < height.length; i++) {
            int minHeight = Math.min(leftHigh[i], rightHigh[i]);
            if (minHeight > height[i]) {
                sum += minHeight - height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
