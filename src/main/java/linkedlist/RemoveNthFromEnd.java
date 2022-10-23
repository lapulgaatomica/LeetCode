package linkedlist;


public class RemoveNthFromEnd {
    public static void main(String[] args) {
        LinkedListt list = new LinkedListt();
        list.addAtHead(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        ListNode listNode = list.getHead();
        removeNthFromEnd2(listNode, 2);
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode currentNode = head;

        while (currentNode != null){
            currentNode = currentNode.next;
            length++;
        }

        if(length == n)
            return head.next;

        int nodeBeforeRemovedIndex = length - n - 1;
        currentNode = head;

        for(int i = 0; i < nodeBeforeRemovedIndex; i++){
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode currentNode = head;
        for(int i = 0; i < n; i++){
            currentNode = currentNode.next;
        }

        if(currentNode == null)
            return head.next;

        ListNode nodeBeforeRemoved = head;

        while (currentNode.next != null){
            currentNode = currentNode.next;
            nodeBeforeRemoved = nodeBeforeRemoved.next;
        }

        nodeBeforeRemoved.next = nodeBeforeRemoved.next.next;
        return head;
    }
}
