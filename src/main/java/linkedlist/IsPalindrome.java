package linkedlist;


public class IsPalindrome {
    public static void main(String[] args) {
        LinkedListt list = new LinkedListt();
        list.addAtHead(1);
//        list.addAtTail(2);
//        list.addAtTail();
//        list.addAtTail(1);
        ListNode listNode = list.getHead();
        System.out.println(isPalindrome(listNode));
    }

    public static boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode countNode = head;
        while (countNode != null){
            length++;
            countNode = countNode.next;
        }
        int halfway = (length / 2) + (length % 2);
        int count = 0;
        ListNode halfwayPointer = head;
        ListNode tail = halfwayPointer;
        while (count < halfway){
            tail = halfwayPointer;
            halfwayPointer = halfwayPointer.next;
            count++;
        }
        ListNode secondHalfReversed = reverseList(halfwayPointer);
        tail.next = secondHalfReversed;

        count = 0;

        ListNode rightPointer = head;
        while (count < halfway){
            rightPointer = rightPointer.next;
            count++;
        }

        ListNode leftPointer = head;
        while (rightPointer != null){
            if(rightPointer.val != leftPointer.val)
                return false;
            rightPointer = rightPointer.next;
            leftPointer = leftPointer.next;
        }

        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode currentNode = head;

        while (currentNode != null){
            ListNode next = currentNode.next;
            currentNode.next = previous;
            previous = currentNode;
            currentNode = next;
        }

        return previous;
    }
}
