package union_find;

import java.util.Arrays;

class friend_circle {
    static int count;
    static int[]  roots, size;
    // weighted union find with path compression
    public static int findCircleNum(int[][] M) {
        int n = M.length;
        roots = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            roots[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) union(i, j);
            }
        }
        return count;
    }


    private static int find(int i) {
        int root = i;
        while (root != roots[root]) root = roots[root];
        while (i != root) {
            int tempI = roots[i];
            roots[i] = root;
            i = tempI;
        }
        return i;
    }

    private static void union(int i, int j) {
        int rootI = find(i), rootJ = find(j);
        if (rootI == rootJ) return;
        if (size[rootI] < size[rootJ]) {
            roots[rootI] = rootJ;
            size[rootJ] += size[rootI];
        } else {
            roots[rootJ] = rootI;
            size[rootI] += size[rootJ];
        }
        count--;
    }

    public static void main(String[] args) {
        int[][] input =
                {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                 {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                 {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                 {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                 {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                 {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                 {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                 {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                 {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                 {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                 {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                 {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                 {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                 {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
        System.out.println(findCircleNum(input));
    }
}
