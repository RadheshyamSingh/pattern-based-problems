package com.radhe.fastslowpointers;

class ReorderList {

    public static void reorder(ListNode head) {
        if (null == head || null == head.next) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of linked list
        ListNode secondHalfHead = reverse(slow);
        ListNode firstHalfHead = head;

        printLinkedList(head);
        printLinkedList(secondHalfHead);

        // merge the items

        while (null != firstHalfHead && null != secondHalfHead) {
            ListNode firstHalfNext = firstHalfHead.next;
            ListNode secondHalfNext = secondHalfHead.next;
            firstHalfHead.next = secondHalfHead;
            secondHalfHead.next = firstHalfNext;
            firstHalfHead = firstHalfNext;
            secondHalfHead = secondHalfNext;
        }

        if (firstHalfHead != null)
            firstHalfHead.next = null;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (null != curr) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static void printLinkedList(ListNode head) {
        while (null != head) {
            System.out.print(" " + head.value + ", ");
            head = head.next;
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        ReorderList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
