package union_find;

import java.util.Arrays;

public class redundant_connection {
    private static class UF {
        int count;
        int[] roots, size;

        public UF(int n) {
            count = n;
            // 注意这里因为index是从1开始的，所以roots[0]和size[0]都是dummy
            roots = new int[n+1]; size = new int[n+1];
            for (int i = 0; i < n + 1; i++) {
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

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n);
        int[] result = new int[2];
        for (int[] edge : edges) {
            // 两个点connected->构成循环
            if (!uf.connected(edge[0], edge[1])) {
                uf.union(edge[0], edge[1]);
            } else {
                result = edge;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }
}
