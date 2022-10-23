package linkedlist;

import listnode.ListNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetectCycle {
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while(head.next != null){
            if(!set.add(head))
                return head;
            head = head.next;
        }

        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        ListNode intersect = getIntersect(head);
        if(intersect == null)
            return null;

        while(intersect != head){
            head = head.next;
            intersect = intersect.next;
        }

        return head;
    }

    public static ListNode getIntersect(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return fast;
            }
        }

        return null;
    }


}
