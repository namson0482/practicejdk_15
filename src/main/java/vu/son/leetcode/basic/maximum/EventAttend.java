package vu.son.leetcode.basic.maximum;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
 *
 * You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.
 *
 * Return the maximum number of events you can attend.
 */
@Slf4j
public class EventAttend {

    EventAttend() {

    }

    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        int i = 0, result = 0, days = 0, length = events.length;
        while (!pq.isEmpty() || i < length) {
            if(i<length) {
                log.info("events[{}][0]: {}", i, events[i][0]);
            }
            if (pq.isEmpty()) {
                days = events[i][0];
            }

            while (i < length && events[i][0] <= days) {
                log.info("events[{}}][0] - {} <= days - {}", i, events[i][0], days);
                pq.offer(events[i++][1]);
            }
            pq.poll();
            ++result; ++days;
            while (!pq.isEmpty() && pq.peek() < days) {
                pq.poll();
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int [][]events = new int[][]
                                    {
                                            {1, 2},
                                            {2, 3},
                                            {3, 4},
                                            {1, 2},

                                    };
        EventAttend eventAttend = new EventAttend();
        log.info("Maximum number of events you can attend: {}", eventAttend.maxEvents(events));
    }
}
