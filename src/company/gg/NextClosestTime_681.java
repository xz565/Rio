package company.gg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * HH:MM
 */
public class NextClosestTime_681 {

    public static String nextClosestTime(String time) {
        int timeInMinute = 60 * Integer.parseInt(time.substring(0, 2));
        timeInMinute += Integer.parseInt(time.substring(3, 5));

        Set<Integer> allowedInts = new HashSet<>();

        for (char c : time.toCharArray())
            if (c != ':') {
                allowedInts.add(c - '0');
        }
        while (true) {
            timeInMinute = (timeInMinute + 1) % (24 * 60);
            int min = timeInMinute % 60;
            int hour = timeInMinute / 60;
            if (allowedInts.contains(min / 10) && allowedInts.contains(min % 10)
                && allowedInts.contains(hour / 10) && allowedInts.contains(hour % 10)) {
                return String.format("%02d:%02d", hour, min);
            }
        }
    }

    static int MIN = Integer.MAX_VALUE;
    // dfs with allowed digits, with permutation with duplicated
    // TODO
    public static String nextClosestTime_2(String time) {
        List<Integer> allowedInts = new ArrayList<>();
        for (char c : time.toCharArray())
            if (c != ':') {
                allowedInts.add(c - '0');
        }
        Collections.sort(allowedInts);

        List<String> result = new ArrayList<>();
        dfs(allowedInts, getTimeInMin(new StringBuilder(time).deleteCharAt(2).toString()),
                "", new boolean[4], result);

        return result.get(0);
    }

    private static void dfs(List<Integer> allowedInts, int val, String curt, boolean[] used, List<String> rst) {
        if (curt.length() == allowedInts.size()) {

            if (Integer.valueOf(curt.substring(0,2)) < 24 && Integer.valueOf(curt.substring(2,4)) <= 60) {
                int diff = (getTimeInMin(curt) - val) % (24 * 60);
                if (diff < 0 && diff <= 60 * 24 && diff<MIN){
                    rst.clear();
                    rst.add(curt);
                }
            }
            return;
        }

        for (int i = 0; i < allowedInts.size(); i++)
            if (!used[i]) {
            curt = curt + allowedInts.get(i);
            used[i] = true;
            dfs(allowedInts, val, curt, used, rst);
            curt = curt.substring(0, curt.length());
            used[i] = false;
        }
    }

    private static int getTimeInMin(String time) {
        int valueInMin = 60 * Integer.valueOf(time.substring(0,2));
        valueInMin += Integer.valueOf(time.substring(2,4));
        return valueInMin;
    }


    public static void main(String[] args) {
        System.out.println(nextClosestTime_2("19:20"));
        System.out.println(nextClosestTime("23:59"));
        System.out.println(nextClosestTime("03:59"));
    }
}
