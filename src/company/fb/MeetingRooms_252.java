package company.fb;

import java.util.Arrays;
import java.util.Comparator;

import common.types.Interval;

public class MeetingRooms_252 {

    public boolean canAttendMeetings(Interval[] intervals) {

        Arrays.sort(intervals, new Comparator<Interval>() {
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

        Interval prev = null;
        for (Interval interval : intervals) {
            if (prev != null && interval.start < prev.end) {
                return false;
            } else {
                prev = interval;
            }
        }
        return true;
    }
}
