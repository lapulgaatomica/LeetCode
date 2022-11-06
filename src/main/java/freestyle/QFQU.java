package freestyle;

public class QFQU {
    int[] root;
    int[] rank;

    public QFQU(int size){
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

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            if(rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else if(rank[rootY] < rank[rootX])
                root[rootY] = rootX;
            else {
                root[rootX] = rootY;
                rank[rootY] += 1;
            }

        }
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}
