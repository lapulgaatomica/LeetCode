package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Insert {
    public static void main(String[] args) {

    }

    public static Node insert(Node head, int insertVal) {
        return head;
    }

    public static Node getSmallest(Node head) {
        Node smallest = head;
        Set<Node> set = new HashSet<>();

        while (set.add(head)){
            if(head.val <= smallest.val)
                smallest = head;
            head = head.next;
        }
        return smallest;
    }
}
