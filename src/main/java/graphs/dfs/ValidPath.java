package graphs.dfs;

import java.util.*;

public class ValidPath {
    public static void main(String[] args) {
        System.out.println(validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adjacencyList.add(new ArrayList<>());

        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            adjacencyList.get(x).add(y);
            adjacencyList.get(y).add(x);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        boolean[] seen = new boolean[n];

        while (!stack.isEmpty()){
            int currentVertex = stack.pop();
            if(seen[currentVertex])
                continue;
            if(currentVertex == destination)
                return true;

            seen[currentVertex] = true;
            for(int neighbor : adjacencyList.get(currentVertex))
                stack.push(neighbor);
        }

        return false;
    }
}
