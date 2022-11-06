package freestyle;

public class QFPC {
    int[] root;

    public QFPC(int size){
        root = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = 1;
        }
    }

    public int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    public void union(int x, int y){
        int rootX = root[x];
        int rootY = root[y];
        if(rootX != rootY){
            for(int i = 0; i < root.length; i++){
                if(i == rootY)
                    root[i] = rootX;
            }
        }
    }

    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}
