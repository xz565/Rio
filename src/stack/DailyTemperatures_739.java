package stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class DailyTemperatures_739 {
    // Stack (decending)
    // classic Google question, You make an observation first, then solve the problem based on that.
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] rst = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                rst[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))
                .boxed()
                .collect(Collectors.toList()));
        System.out.println(Arrays.stream(dailyTemperatures(new int[]{73, 75, 75, 76, 69, 68, 76, 73}))
                .boxed()
                .collect(Collectors.toList()));
        System.out.println(Arrays.stream(dailyTemperatures(new int[]{73}))
                .boxed()
                .collect(Collectors.toList()));
        System.out.println(Arrays.stream(dailyTemperatures(new int[]{73, 74, 75}))
                .boxed()
                .collect(Collectors.toList()));
        System.out.println(Arrays.stream(dailyTemperatures(new int[]{73, 72, 71}))
                .boxed()
                .collect(Collectors.toList()));
        System.out.println(Arrays.stream(dailyTemperatures(new int[]{73, 73}))
                .boxed()
                .collect(Collectors.toList()));
        System.out.println(Arrays.stream(dailyTemperatures(new int[]{73, 72, 71, 72, 73}))
                .boxed()
                .collect(Collectors.toList()));
    }
}
