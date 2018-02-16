/*
*
* 130. Surrounded Regions
* https://leetcode.com/problems/surrounded-regions/description/
* http://www.lintcode.com/zh-cn/problem/surrounded-regions/
*
* 总结：
* 1. int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
* 2. 存棋盘上的点时，只用存一个integer，存的时候将 (x,y) 变为 num: (x * n + y)，取的时候x是 num / n, y是 num % n
*
* */

package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class surrounded_regions {

    /*BFS solution*/
    static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        // 把四个边界的'o'变为'W' (反向思维，考虑没被围绕的边界的'O')
        for (int i = 0; i < m; i++) {
            bfs(board, i, 0);
            bfs(board, i , n - 1);
        }
        for (int j = 0; j < n; j++) {
            bfs(board, 0, j);
            bfs(board, m - 1, j);
        }
        // 最后把所有的'W'变成'O'，其他变成'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'W') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    public static void bfs(char[][] board, int x, int y) {
        int m = board.length, n = board[0].length;
        if (board[x][y] != 'O') return;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x * n + y);
        board[x][y] = 'W';
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 0; i < direction.length; i++) {
                int newX = temp / n + direction[i][0], newY = temp % n + direction[i][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && board[newX][newY] == 'O') {
                    board[newX][newY] = 'W';
                    queue.add(newX * n + newY);
                }
            }
        }
    }

    /*union find solution*/
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

    public void solve2(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        UF uf = new UF(n * m + 1); // an extra dummy node: roots[m*n]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
}
