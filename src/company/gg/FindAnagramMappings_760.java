package company.gg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindAnagramMappings_760 {

    public static int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        int[] rst = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            rst[i] = map.get(A[i]);
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28}))
                .boxed().collect(Collectors.toList()));
    }
}
