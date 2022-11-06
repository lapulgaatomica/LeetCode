package graphs.dfs;

import java.util.*;

public class LeadsToDestination {
    public static void main(String[] args) {
        System.out.println(leadsToDestination(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {2, 1}}, 0, 3));
        System.out.println(leadsToDestination(3, new int[][]{{0, 1}, {0, 2}}, 0, 2));
        System.out.println(leadsToDestination(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}, 0, 3));
    }

    public static boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = buildDigraph(n, edges);
        return leadsToDest(graph, source, destination, new Color[n]);
    }

    private static boolean leadsToDest(List<List<Integer>> graph, int node, int dest, Color[] states) {

        // If the state is GRAY, this is a backward edge and hence, it creates a loop.
        if (states[node] != null) {
            return states[node] == Color.BLACK;
        }

        // If this is a leaf node, it should be equal to the destination.
        if (graph.get(node).isEmpty()) {
            return node == dest;
        }

        // Now, we are processing this node. So we mark it as GRAY
        states[node] = Color.GRAY;

        for (int next : graph.get(node)) {
            // If we get a `false` from any recursive call on the neighbors, we short circuit and return from there.
            if (!leadsToDest(graph, next, dest, states)) {
                return false;
            }
        }

        // Recursive processing done for the node. We mark it BLACK
        states[node] = Color.BLACK;
        return true;
    }

    private static List<List<Integer>> buildDigraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        return graph;
    }
}

enum Color { GRAY, BLACK }