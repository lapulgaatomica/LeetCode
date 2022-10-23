package linkedlist;

public class LinkedListt {
    private ListNode head;

    public LinkedListt(){
        head = null;
    }

    private ListNode getNode(int index){
        ListNode cur = head;
        for(int i = 0; i < index && cur != null; i++){
            cur = cur.next;
        }
        return cur;
    }

    private ListNode getTail(){
        ListNode cur = head;

        while (cur != null && cur.next != null){
            cur = cur.next;
        }
        return cur;
    }

    public int get(int index){
        ListNode cur = getNode(index);
        return cur == null ? -1 : cur.val;
    }

    public void addAtHead(int val){
        ListNode cur = new ListNode(val);
        cur.next = head;
        head = cur;
    }

    public void addAtTail(int val){
        if(head == null){
            addAtHead(val);
            return;
        }
        ListNode prev = getTail();
        ListNode cur = new ListNode(val);
        prev.next = cur;
    }

    public void addAtIndex(int index, int val){
        if(index == 0){
            addAtHead(val);
            return;
        }

        ListNode prev = getNode(index - 1);
        if(prev == null)
            return;

        ListNode cur = new ListNode(val);
        ListNode next = prev.next;
        cur.next = next;
        prev.next = cur;
    }

    public void deleteAtIndex(int index){
        ListNode cur = getNode(index);
        if(cur == null)
            return;

        ListNode next = cur.next;

        if(index == 0)
            head = next;
        else {
            ListNode prev = getNode(index - 1);
            prev.next = next;
        }
    }

    public ListNode getHead(){
        return head;
    }
}
