package listnode.easy;

import listnode.ListNode;

public class MergeTwoLists {
    //https://leetcode.com/problems/merge-two-sorted-lists/
    public static void main(String[] args) {
        ListNode firstList = new ListNode(1);
        firstList.next = new ListNode(2);
        firstList.next.next = new ListNode(4);

        ListNode secondList = new ListNode(1);
        secondList.next = new ListNode(3);
        secondList.next.next = new ListNode(4);

        ListNode merged = mergeTwoLists(firstList, secondList);
        System.out.println(merged);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        // Problem wasn't solved by me
        ListNode head = new ListNode(0);
        ListNode last = head;

        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                last.next = l2;
                l2 = l2.next;
            }else{
                last.next = l1;
                l1 = l1.next;
            }
            last = last.next;
        }

        if(l1 == null) {
            last.next = l2;
        } else {
            last.next = l1;
        }

        return head.next;
    }
}

