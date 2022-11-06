package graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {
    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }

        dfs(graph, 0, new ArrayList<>(), paths);
        return paths;
    }

    private static void dfs(int[][] graph, int currentNode, ArrayList<Integer> path, List<List<Integer>> paths) {
        path.add(currentNode);
        if(currentNode == graph.length - 1){
            paths.add(new ArrayList<>(path));
        }
        int[] nextNodes = graph[currentNode];
        for(int node : nextNodes){
            dfs(graph, node, path, paths);
            path.remove(path.size() - 1);
        }
    }
}
