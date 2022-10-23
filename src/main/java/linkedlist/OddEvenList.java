package linkedlist;

public class OddEvenList {
    public static void main(String[] args) {
        LinkedListt list = new LinkedListt();
        list.addAtHead(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        ListNode listNode = list.getHead();
        ListNode oddEven = oddEvenList(listNode);
        System.out.println();
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        int count = 0;

        while(head != null){
            count++;
            if(count % 2 == 0){
                if(evenHead == null){
                    evenHead = new ListNode(head.val);
                    evenTail = evenHead;
                }else{
                    evenTail.next = new ListNode(head.val);
                    evenTail = evenTail.next;
                }
            }else{
                if(oddHead == null){
                    oddHead = new ListNode(head.val);
                    oddTail = oddHead;
                }else{
                    oddTail.next = new ListNode(head.val);
                    oddTail = oddTail.next;
                }
            }
            head = head.next;
        }
        if(oddHead != null)
            oddTail.next = evenHead;

        return oddHead;
    }
}
