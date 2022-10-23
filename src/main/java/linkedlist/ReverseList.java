package linkedlist;

public class ReverseList {
    public static void main(String[] args) {
        LinkedListt list = new LinkedListt();
        list.addAtHead(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        ListNode listNode = list.getHead();
        ListNode reversed = reverseList(listNode);
        System.out.println();
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
