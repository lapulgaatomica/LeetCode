package recursion;

import listnode.ListNode;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println();
        ListNode node = swapPairs(listNode);
        System.out.println();
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        head.next = head.next.next;
        newHead.next = head;
        head = newHead;
        head.next.next = swapPairs(head.next.next);
        return head;
    }
}
