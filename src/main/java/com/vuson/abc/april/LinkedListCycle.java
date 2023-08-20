package com.vuson.abc.april;

import com.vuson.leetcode.string.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        Set seen = new HashSet();
        while(head != null) {
            if(seen.contains(head)) {
                return true;
            }
            seen.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
