package sorting;

import listnode.ListNode;

public class InsertionSortList {
    public static void main(String[] args) {
        ListNode node = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(5, new ListNode(0)))));
        System.out.println(node);
        ListNode sorted = insertionSortList(node);
        System.out.println(sorted);
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;

        while (curr != null){
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val <= curr.val)
                prev = prev.next;

            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }
        return dummy.next;
    }
}
