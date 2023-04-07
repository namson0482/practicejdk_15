package com.vuson.leetcode.string.linkedlist;

public class ListNode {

    public int val;

    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static final ListNode initListNodeFromArray(int []array) {
        ListNode result = null;
        for(int i = 0;i<array.length;i++) {
            if(i==0) {
                result = new ListNode(array[i]);
            } else {
                ListNode temp = new ListNode(array[i], result);
                result = temp;
            }
        }
        return result;
    }
}
