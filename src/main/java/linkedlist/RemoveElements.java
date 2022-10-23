package linkedlist;

public class RemoveElements {
    public static void main(String[] args) {
        LinkedListt list = new LinkedListt();
        list.addAtHead(6);
        list.addAtHead(1);
        list.addAtTail(2);
        list.addAtTail(6);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        list.addAtTail(6);
        ListNode listNode = list.getHead();
        ListNode removed = removeElements(listNode, 6);
        System.out.println();
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null){
            ListNode next = current.next;
            if(current.val == val){
                if(previous == null){
                    head = head.next;
                }else{
                    previous.next = next;
                }
            }else{
                previous = current;
            }
            current = next;
        }
        return head;
    }
}
