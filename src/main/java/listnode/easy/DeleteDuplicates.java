package listnode.easy;

import listnode.ListNode;

public class DeleteDuplicates {
    public static void main(String[] args) {
        // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println(deleteDuplicates(l1));
//        deleteDuplicates(l1);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;

        while(list != null && list.next != null) {
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }

        return head;
    }
}
