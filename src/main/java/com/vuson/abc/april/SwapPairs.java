package com.vuson.abc.april;

import com.vuson.leetcode.string.linkedlist.ListNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        int count = 0;
        ListNode temp1 = null;
        ListNode temp2 = null;
        ListNode temp3 = head;
        while(head != null) {
            count++;
            if(count%2 ==1) {
                temp1 = head;
            }
            if(count%2 == 0) {
                temp2 = head;
                count = 0;
                int val = temp1.val;
                temp1.val = temp2.val;
                temp2.val = val;
            }
            head = head.next;
        }
        return temp3;
    }

    public static void main(String[] args) {
        ListNode node  = new ListNode(1);
        ListNode node1  = new ListNode(2);
        node.next = node1;
        ListNode node2  = new ListNode(3);
        node1.next = node2;
        ListNode node3  = new ListNode(4);
        node2.next = node3;

        ListNode head1 = node;

        ListNode res = swapPairs(head1);
        System.out.println();
        String stemp = "";
        while(res!=null) {
            stemp += res.val + " ";
            res = res.next;
        }
        log.info(stemp);
    }
}
