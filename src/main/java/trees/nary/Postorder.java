package trees.nary;

import java.util.ArrayList;
import java.util.List;

public class Postorder {
    public List<Integer> postorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        recurse(root, answer);
        return answer;
    }

    private void recurse(Node root, List<Integer> answer) {
        if(root == null)
            return;
        for(Node child : root.children)
            recurse(child, answer);
        answer.add(root.val);
    }
}
