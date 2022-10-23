package linkedlist;

import listnode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        int maxLength = 10000;
        int i = 0;
        ListNode next = head;

        while (i < maxLength && next != null){
            next = next.next;
            i++;
        }

        return next != null;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null){
            if(!set.add(head))
                return true;
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle3(ListNode head){
        ListNode slow = head.next;
        ListNode fast = null;
        if(slow != null)
            fast = slow.next;

        while (slow != null && fast != null && fast != slow){
            slow = slow.next;
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
            else
                return false;
        }

        return slow == fast;
    }
}
