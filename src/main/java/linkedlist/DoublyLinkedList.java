package linkedlist;

public class DoublyLinkedList {
    private DoublyListNode head;

    public DoublyLinkedList(){
        head = null;
    }

    private DoublyListNode getNode(int index){
        DoublyListNode cur = head;

        for(int i = 0; i < index && cur != null; i++){
            cur = cur.next;
        }
        return cur;
    }

    private DoublyListNode getTail(){
        DoublyListNode cur = head;
        while (cur != null && cur.next != null){
            cur = cur.next;
        }
        return cur;
    }

    public int get(int index){
        DoublyListNode cur = getNode(index);
        return cur == null ? -1 : cur.val;
    }

    public void addAtHead(int val){
        DoublyListNode cur = new DoublyListNode(val);
        cur.next = head;

        if(head != null)
            head.prev = cur;

        head = cur;
    }

    public void addAtTail(int val){
        if(head == null){
            addAtHead(val);
            return;
        }
        DoublyListNode previousTail = getTail();
        DoublyListNode currentTail = new DoublyListNode(val);
        previousTail.next = currentTail;
        currentTail.prev = previousTail;
    }

    public void addAtIndex(int index, int val){
        if(index == 0){
            addAtHead(val);
            return;
        }
        DoublyListNode previousTail = getNode(index - 1);
        if(previousTail == null)
            return;

        DoublyListNode currentTail = new DoublyListNode(val);
        DoublyListNode next = previousTail.next;
        currentTail.prev = previousTail;
        currentTail.next = next;
        previousTail.next = currentTail;
        if(next != null)
            next.prev = currentTail;
    }

    public void deleteAtIndex(int index){
        DoublyListNode cur = getNode(index);
        if(cur == null)
            return;
        DoublyListNode prev = cur.prev;
        DoublyListNode next = cur.next;
        if(prev != null)
            prev.next = next;
        else
            head = next;

        if(next != null)
            next.prev = prev;
    }
}
