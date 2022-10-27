package linkedlist;

public class RotateRight {
    public static void main(String[] args) {
        LinkedListt linkedListt1 = new LinkedListt();
        linkedListt1.addAtHead(1);
        linkedListt1.addAtTail(2);
        linkedListt1.addAtTail(3);
        linkedListt1.addAtTail(4);
        linkedListt1.addAtTail(5);
        ListNode list1 = linkedListt1.getHead();
        rotateRight(list1, 2);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        int size = 0;

        ListNode walk = head;
        while(walk != null){
            size++;
            walk = walk.next;
        }

        int numberToMove = size - (k % size);
        if(numberToMove == size)
            return head;
        walk = head;
        ListNode tail = head;

        while (numberToMove > 0){
            tail = walk;
            walk = walk.next;
            numberToMove--;
        }
        tail.next = null;
        ListNode walkTail = walk;
        ListNode prev = walkTail;

        while (walkTail != null){
            prev = walkTail;
            walkTail = walkTail.next;
        }
        prev.next = head;
        return walk;
    }
}
