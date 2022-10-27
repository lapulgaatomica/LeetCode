package linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        LinkedListt linkedListt1 = new LinkedListt();
        linkedListt1.addAtHead(1);
        linkedListt1.addAtTail(2);
        linkedListt1.addAtTail(4);
        ListNode list1 = linkedListt1.getHead();
        LinkedListt linkedListt2 = new LinkedListt();
        linkedListt2.addAtHead(2);
        linkedListt2.addAtTail(8);
        linkedListt2.addAtTail(4);
        ListNode list2 = linkedListt2.getHead();
        ListNode addition = addTwoNumbers(list1, list2);
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remainder = 0;
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while (l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                int sum = l1.val + l2.val;
                int numToAdd = (sum + remainder) % 10;
                remainder = (sum + remainder) / 10;
                tail.next = new ListNode(numToAdd);
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                int numToAdd = (l1.val + remainder) % 10;
                remainder = (l1.val + remainder) / 10;
                tail.next = new ListNode(numToAdd);
                l1 = l1.next;
            }else{
                int numToAdd = (l2.val + remainder) % 10;
                remainder = (l2.val + remainder) / 10;
                tail.next = new ListNode(numToAdd);
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(remainder > 0)
            tail.next = new ListNode(remainder);
        return head.next;
    }
}
