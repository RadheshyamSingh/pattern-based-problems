package com.radhe.fastslowpointers;

/**
 * Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 */

public class LinkedListCycleNode {
    public static ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        System.out.println("has cycle : " + hasCycle);

        if (hasCycle) {
            /// get cycle length
            int cycleLength = 1;
            ListNode pointer = slow.next;
            while (pointer != slow) {
                cycleLength++;
                pointer = pointer.next;
            }

            //.out.println("Cycle Length : " + cycleLength);

            ListNode pointer1 = head;
            ListNode pointer2 = head;
            while (cycleLength > 0) {
                cycleLength--;
                pointer1 = pointer1.next;
            }

            while (pointer1 != pointer2) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }

            //System.out.println("junction : " + pointer2.value);

            return pointer2;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycleNode.detectCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycleNode.detectCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycleNode.detectCycle(head));
    }

}

