package com.vuson.abc.april;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@AllArgsConstructor
class Meeting {
    int start;
    int end;
}

@Slf4j
public class MeetingRoom {
    private static boolean canAttendMeetingsMe(int[][] intervals) {
        List<Meeting> list = new ArrayList<>();
        for(int i=0;i<intervals.length;i++) {
            Meeting meeting = new Meeting(intervals[i][0], intervals[i][1]);
            list.add(meeting);
        }
        Collections.sort(list, (o1, o2) -> o1.start > o2.start ?  1: - 1);
        int count = 1;
        for(int i=1;i<list.size();i++) {
            Meeting obj1 = list.get(i-1);
            Meeting obj2 = list.get(i);
            if(obj2.start >= obj1.end) {
                count++;
            }
        }

        return count == intervals.length ;
    }

    public static boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i=0;i<intervals.length-1;i++) {
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;

    }

    public static int minMeetingRoomsSecond(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> allocator =
                new PriorityQueue(
                        intervals.length,
                        Comparator.comparingInt(a -> (int) a));

        Arrays.sort(
                intervals,
                Comparator.comparingInt(a -> a[0]));

        allocator.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }

    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i=0; i<n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int min = 0;
        int count = 0;
        int si = 0, ei = 0;

        while(si < n && ei < n) {
            if(start[si] < end[ei]) {
                si++;
                count++;
            } else {
                ei++;
                count--;
            }

            min = Math.max(min, count);
        }

        return min;
    }

    public static void main(String[] args) {
        int [][]intervals = {
                {0,30},{5,10},{15,20}
//                {7,10},{2,4}
        };

        log.info(minMeetingRooms(intervals) + "");
    }
}
