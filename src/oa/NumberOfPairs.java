package oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberOfPairs {

    public static int numberOfPairs(int[] a, long k) {

        int count = 0;
        int halfCount = 0;
        Set<Long> diffSet = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] * 2l == k) {
                if (++halfCount == 2) count++;
            } else {
                diffSet.add(k - (long)a[i]);
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (diffSet.contains((long)a[i])) {
                count++;
                diffSet.remove((long) a[i]);
                diffSet.remove(k - a[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[] {1,2,3,6,7,8,9,1}, 10));
        System.out.println(numberOfPairs(new int[] {1, 3, 46, 1, 3, 9}, 47));
        System.out.println(numberOfPairs(new int[] {6,12,3,9,3,5,1}, 12));

        Map<Integer, Integer> map = new HashMap<>();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return 0;
            }
        });
    }
}
