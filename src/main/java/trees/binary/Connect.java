package trees.binary;

import java.util.LinkedList;
import java.util.Queue;

public class Connect {
    public static Nodee connect(Nodee root) {
        if(root == null || root.left == null)
            return root;

        Queue<Nodee> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Nodee current = queue.poll();
                if(i != size - 1){
                    current.next = queue.peek();
                }
                if(current.left != null)
                    queue.offer(current.left);
                if(current.right != null)
                    queue.offer(current.right);
            }
        }
        return root;
    }

    public static Nodee connect2(Nodee root) {
        if(root == null )
            return root;

        Queue<Nodee> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Nodee current = queue.poll();
                if(i != size - 1){
                    current.next = queue.peek();
                }
                if(current.left != null)
                    queue.offer(current.left);
                if(current.right != null)
                    queue.offer(current.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Nodee root = new Nodee(1, new Nodee(2), new Nodee(3), null);
        root.left.left = new Nodee(4);
        root.left.right = new Nodee(5);
        root.right.left = new Nodee(6);
        root.right.right = new Nodee(7);
        System.out.println();
        Nodee connected = connect(root);
        System.out.println();
    }
}

class Nodee {
    public int val;
    public Nodee left;
    public Nodee right;
    public Nodee next;

    public Nodee() {}

    public Nodee(int _val) {
        val = _val;
    }

    public Nodee(int _val, Nodee _left, Nodee _right, Nodee _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
