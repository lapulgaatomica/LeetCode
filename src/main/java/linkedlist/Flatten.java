package linkedlist;

public class Flatten {
    public static void main(String[] args) {

    }

    public static Node flatten(Node head) {
        if(head.child != null){
            Node flat = flatten(head.child);
            head.next = flat;
            flat.prev = head;
            flat.next = head.next.next;
            head.next.prev = flat;
        }else{
            head = head.next;
        }
        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}