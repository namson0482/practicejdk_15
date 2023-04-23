package com.vuson.abc.april;

import com.vuson.leetcode.string.linkedlist.ListNode;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {

        List<ListNode> lst = new ArrayList<>();
        for (ListNode item : lists) {
            while (item != null) {
                lst.add(item);
                item = item.next;
            }
        }
        Collections.sort(lst, (o1, o2) -> {
            if(o1.val > o2.val) return 1;
            else if(o1.val < o2.val) return -1;
            else return 0;
        });
        if(lst.size() == 0) return null;
        ListNode head = lst.get(0);
        ListNode move = head;
        for(int i=1;i< lst.size();i++) {
            ListNode temp = lst.get(i);
            move.next = temp;
            move = temp;
            if(i == lst.size() - 1) {
                move.next = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node  = new ListNode(1);
        ListNode node1  = new ListNode(2);
        node.next = node1;
        ListNode node2  = new ListNode(2);
        node1.next = node2;

        ListNode head1 = node;

        node  = new ListNode(1);
        node1  = new ListNode(1);
        node2  = new ListNode(2);
        node.next = node1;
        node1.next = node2;
        ListNode head2 = node;

//        node  = new ListNode(2);
//        node1  = new ListNode(6);
//        node.next = node1;
//        ListNode head3 = node;

        ListNode[] arr = new ListNode[] {head1, head2};
        ListNode res = mergeKLists(arr);
        System.out.println();
        String stemp = "";
        while(res!=null) {
            stemp += res.val + " ";
            res = res.next;
        }
        log.info(stemp);
    }
}
