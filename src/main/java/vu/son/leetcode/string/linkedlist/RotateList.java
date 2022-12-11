package vu.son.leetcode.string.linkedlist;

import java.util.Stack;

public class RotateList {

    public int getSize(Stack stack, ListNode head) {
        ListNode temp = head;
        int size = 1;
        stack.add(temp);
        while (temp.next != null) {
            temp = temp.next;
            stack.add(temp);
            size++;
        }
        return size;
    }

    public ListNode rotateRightTemp(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        Stack stack = new Stack();
        int size = getSize(stack, head);
        int rotate = k % size;
        while (rotate > 0) {
            rotate--;
            ListNode tempOne = (ListNode) stack.pop();
            tempOne.next = head;
            head = tempOne;
            ListNode tempTwo = (ListNode) stack.peek();
            tempTwo.next = null;
        }

        return head;
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode temp = head;

        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        int rotation = k < count ? k : k % count;
        temp = head;
        ListNode start = head;
        for (int i = 1; i < count - rotation; i++) {
            temp = temp.next;
        }
        ListNode node = temp;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;
        head = node.next;
        node.next = null;
        return head;
    }

    public static void main(String[] args) {
        LeetCodeLinkedList leetCodeLinkedList = new LeetCodeLinkedList();
        leetCodeLinkedList = leetCodeLinkedList.insert(leetCodeLinkedList, 1);
        leetCodeLinkedList = leetCodeLinkedList.insert(leetCodeLinkedList, 2);
        leetCodeLinkedList = leetCodeLinkedList.insert(leetCodeLinkedList, 3);
        leetCodeLinkedList = leetCodeLinkedList.insert(leetCodeLinkedList, 4);
        leetCodeLinkedList = leetCodeLinkedList.insert(leetCodeLinkedList, 5);
        leetCodeLinkedList.printValues();

        RotateList rotateList = new RotateList();
        ListNode head = rotateList.rotateRight(leetCodeLinkedList.head, 2);
        leetCodeLinkedList.head = head;
        leetCodeLinkedList.printValues();
    }
}
