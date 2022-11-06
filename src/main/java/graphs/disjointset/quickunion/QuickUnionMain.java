package graphs.disjointset.quickunion;

public class QuickUnionMain {
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5));
        System.out.println(uf.connected(5, 7));
        System.out.println(uf.connected(4, 9));
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9));
    }
}
