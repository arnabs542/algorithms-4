/*
*
* LC 130. Surrounded Regions
*
* */

package union_find;

import java.util.Arrays;

public class surrounded_regions {
    private class UF {
        int count;
        int[] roots, size;

        public UF(int n) {
            this.count = n;
            roots = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
                size[i] = 1;
            }
        }
        private int find(int i) {
            int root = i;
            while (root != roots[root]) root = roots[root];
            while (i != root) {
                int tempI = roots[i];
                roots[i] = root;
                i = tempI;
            }
            return i;
        }
        private void union(int i, int j) {
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
        private boolean connected(int i, int j) {
            return find(i) == find(j);
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        UF uf = new UF(n * m + 1); // an extra dummy node: roots[m*n]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if a 'O' node is on the boundary, connect it to the dummy node
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    uf.union(i * n + j, m * n);
                } else if (board[i][j] == 'O') { // connect a 'O' node to its neighbor 'O' nodes
                    if(board[i-1][j] == 'O')
                        uf.union(i * n + j,(i - 1) * n + j);
                    if(board[i+1][j] == 'O')
                        uf.union(i * n + j,(i + 1) * n + j);
                    if(board[i][j-1] == 'O')
                        uf.union(i * n + j,i * n + j - 1);
                    if(board[i][j+1] == 'O')
                        uf.union(i * n + j,i * n + j + 1);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if a 'O' node is not connected to the dummy node, it is captured
                if (!uf.connected(i * n + j, m * n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board =
                {{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
                 {'X','X','X','X','X','X','X','X','X','O','O','O','X','X','X','X','X','X','X','X'},
                 {'X','X','X','X','X','O','O','O','X','O','X','O','X','X','X','X','X','X','X','X'},
                 {'X','X','X','X','X','O','X','O','X','O','X','O','O','O','X','X','X','X','X','X'},
                 {'X','X','X','X','X','O','X','O','O','O','X','X','X','X','X','X','X','X','X','X'},
                 {'X','X','X','X','X','O','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}};

//        char[][] board =
//                       {{'X','X','X','X','X','X','X','X','X','X','X'},
//                        {'X','X','X','X','X','O','O','O','X','X','X'},
//                        {'X','O','O','O','X','O','X','O','X','X','X'},
//                        {'X','O','X','O','X','O','X','O','O','O','X'},
//                        {'X','O','X','O','O','O','X','X','X','X','X'},
//                        {'X','O','X','X','X','X','X','X','X','X','X'}};


        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
        surrounded_regions s = new surrounded_regions();
        s.solve(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
