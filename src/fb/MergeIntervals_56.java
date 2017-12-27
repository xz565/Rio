package fb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.types.Interval;

public class MergeIntervals_56 {

    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> rst = new ArrayList<>();
        if (intervals.isEmpty()) {
            return rst;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start > o2.start) {
                    return 1;
                } else if (o1.start < o2.start) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (end < interval.start) {
                rst.add(new Interval(start, end));
                start = interval.start;
            }

            if (end < interval.end) {
                end = interval.end;
            }
        }

        rst.add(new Interval(start, end));
        return rst;
    }
}
