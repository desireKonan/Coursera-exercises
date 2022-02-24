package algorithms.union;

public class TestUnion {
    public static void main(String[] args)
    {
       QuickUnionUF uf = new QuickUnionUF(12);
       uf.union(1, 3);
       uf.union(1, 2);
       System.out.println(uf.connected(1, 2));
    }
}
