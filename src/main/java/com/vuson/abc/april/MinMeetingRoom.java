package com.vuson.abc.april;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


@Slf4j
public class MinMeetingRoom {
    public int minMeetingRoom(int [][]intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Get starts and ends separately
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        // Sort starts and ends array
        Arrays.sort(starts);
        Arrays.sort(ends);

        // Find min needed rooms
        int rooms = 0;
        for (int startIndex = 0, endIndex = 0; startIndex < len; startIndex++) {
            log.info("{} < {}", starts[startIndex], ends[endIndex]);
            if (starts[startIndex] < ends[endIndex]) {
                rooms++;
            } else {
                endIndex++;
            }
        }

        return rooms;
    }

    public static void main(String[] args) {
        int [][]intervals = {{0, 30},
                            {5, 10},
                            {15, 20}};
        MinMeetingRoom min = new MinMeetingRoom();
        System.out.println(min.minMeetingRoom(intervals));
    }
}
