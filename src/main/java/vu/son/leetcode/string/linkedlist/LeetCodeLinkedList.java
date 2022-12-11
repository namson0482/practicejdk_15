package vu.son.leetcode.string.linkedlist;

public class LeetCodeLinkedList {

    ListNode head;

    public LeetCodeLinkedList insert(LeetCodeLinkedList list, int data) {
        ListNode node = new ListNode(data);
        if(list.head == null) {
            list.head = node;
        } else {
            ListNode last = list.head;
            while(last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
        return list;
    }

    public void printValues() {
        ListNode current = head;
        System.out.println("");
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n) {

        // base case. Don't proceed any further
        if (n == 1) {
            return;
        }

        // Keep moving the right pointer one step forward until (n == 1)
        right = right.next;

        // Keep moving left pointer to the right until we reach the proper node
        // from where the reversal is to start.
        if (m > 1) {
            this.left = this.left.next;
        }

        // Recurse with m and n reduced.
        this.recurseAndReverse(right, m - 1, n - 1);

        // In case both the pointers cross each other or become equal, we
        // stop i.e. don't swap data any further. We are done reversing at this
        // point.
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        // Until the boolean stop is false, swap data between the two pointers
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            // Move left one step to the right.
            // The right pointer moves one step back via backtracking.
            this.left = this.left.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }

    public ListNode reverseBetweenTemp(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode con = prev, tail = cur;
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }

    public static void main(String[] args) {
        LeetCodeLinkedList leetCodeLinkedList = new LeetCodeLinkedList();
        leetCodeLinkedList = leetCodeLinkedList.insert(leetCodeLinkedList, 1);
        leetCodeLinkedList = leetCodeLinkedList.insert(leetCodeLinkedList, 2);
        leetCodeLinkedList = leetCodeLinkedList.insert(leetCodeLinkedList, 3);
        leetCodeLinkedList = leetCodeLinkedList.insert(leetCodeLinkedList, 4);
        leetCodeLinkedList = leetCodeLinkedList.insert(leetCodeLinkedList, 5);
//        reverseLinkedList = reverseLinkedList.insert(reverseLinkedList, 6);
//        reverseLinkedList = reverseLinkedList.insert(reverseLinkedList, 7);
//        reverseLinkedList = reverseLinkedList.insert(reverseLinkedList, 8);

        leetCodeLinkedList.printValues();

        leetCodeLinkedList.reverseBetweenTemp(leetCodeLinkedList.head, 2, 4);
        leetCodeLinkedList.printValues();

    }
}
