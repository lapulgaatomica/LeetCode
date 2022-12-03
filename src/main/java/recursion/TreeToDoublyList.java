package recursion;

import java.util.ArrayList;
import java.util.List;

public class TreeToDoublyList {
    public static void main(String[] args) {
        Node node = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));
        Node doubly = treeToDoublyList(node);

        System.out.println();
    }
    public static Node treeToDoublyList(Node root) {
        List<Node> list = new ArrayList<>();
        recurse(root, list);
        Node head = list.get(0);
        Node prev = head;
        Node curr;
        for(int i = 1; i < list.size(); i++){
            curr = list.get(i);
            prev.left = curr;
            curr.right = prev;
            prev = curr;
        }
        prev.left = head;
        return head;
    }

    public static void recurse(Node root, List<Node> list) {
        if(root == null)
            return;
        recurse(root.left, list);
        list.add(root);
        recurse(root.right, list);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}