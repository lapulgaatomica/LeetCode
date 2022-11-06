package graphs.disjointset;

public class ValidTree {
    public static void main(String[] args) {
        System.out.println(validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println(validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3},{1, 3}, {1, 4}}));
    }

    public static boolean validTree(int n, int[][] edges) {
        ValidTreeUnionFInd uf = new ValidTreeUnionFInd(n);

        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];

            if(!uf.union(x, y))
                return false;
        }
        return true;
    }
}

class ValidTreeUnionFInd{
    int[] root;
    int[] rank;

    public ValidTreeUnionFInd(int size){
        root = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    public boolean union(int x, int y){
        int findX = find(x);
        int findY = find(y);

        if(findX == findY)
            return false;
        if(root[findX] > root[findY])
            root[findY] = findX;
        else if(root[findY] > root[findX])
            root[findX] = findY;
        else {
            root[findX] = findY;
            rank[findY] += 1;
        }
        return true;
    }
}