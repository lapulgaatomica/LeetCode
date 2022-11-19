package trees.nary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null)
            return answer;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> innerList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node current = queue.poll();
                innerList.add(current.val);
                List<Node> children = current.children;
                if(children == null || children.isEmpty())
                    continue;
                for(Node child : children)
                    queue.offer(child);
            }
            answer.add(innerList);
        }
        return answer;
    }
}
