package union_find;

public class number_of_connected_components_in_an_undirected_graph {
    private static class UF {
        int count;
        int[] roots, size;

        public UF(int n) {
            count = n;
            roots = new int[n]; size = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
                size[i] = 1;
            }
        }
        private int find(int p) {
            int root = p;
            while (root != roots[root]) root = roots[root];
            while (p != root) {
                int tempP = roots[p];
                roots[p] = root;
                p = tempP;
            }
            return p;
        }
        private void union(int p , int q) {
            int rootP = find(p), rootQ = find(q);
            if (rootP == rootQ) return;
            if (size[rootP] < size[rootQ]) {
                roots[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                roots[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }
        private boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    }

    public static int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(5, edges));
    }
}
