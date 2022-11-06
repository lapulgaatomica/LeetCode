package graphs.disjointset;

import java.util.Arrays;
import java.util.Comparator;

public class EarliestAcq {
    public static void main(String[] args) {
        System.out.println(earliestAcq(new int[][]{{20190101,0,1}, {20190104,3,4}, {20190107,2,3}, {20190211,1,5},
                {20190224,2,4}, {20190301,0,3}, {20190312,1,2}, {20190322,4,5}}, 6));
    }

    public static int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (log1, log2) -> {
            Integer tsp1 = log1[0];
            Integer tsp2 = log2[0];
            return tsp1.compareTo(tsp2);
        });
        EarliestAcqUnionFInd uf = new EarliestAcqUnionFInd(n);
        int count = n;
        for(int[] log : logs){
            if(uf.union(log[1], log[2]))
                count -= 1;
            if(count == 1)
                return log[0];
        }
        return -1;
    }
}

class EarliestAcqUnionFInd{
    int[] root;
    int[] rank;

    public EarliestAcqUnionFInd(int size){
        root = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
            rank[i] = 0;
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
        else{
            root[findX] = findY;
            rank[findY] += 1;
        }
        return true;
    }
}
