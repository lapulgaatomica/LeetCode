package graphs.disjointset;

public class FindCircleNum {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public static int findCircleNum(int[][] isConnected) {
        FindCircleNumUnionFInd uf = new FindCircleNumUnionFInd(isConnected.length);

        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(isConnected[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.getProvinces();
    }
}

class FindCircleNumUnionFInd{
    int[] root;
    int[] rank;
    int provinces;

    public FindCircleNumUnionFInd(int size){
        root = new int[size];
        rank = new int[size];
        provinces = size;

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
        int findX = find(x);
        int findY = find(y);

        if(findX != findY){
            if(root[findX] < root[findY])
                root[findX] = findY;
            else if(root[findY] < root[findX])
                root[findY] = findX;
            else{
                root[findY] = findX;
                rank[findX] += 1;
            }
           provinces--;
        }
    }

    public int getProvinces(){
        return provinces;
    }
}