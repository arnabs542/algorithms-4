/*
*
* 286. Walls and Gates
* https://leetcode.com/problems/walls-and-gates/description/
* http://www.lintcode.com/zh-cn/problem/nearest-exit/
*
*
* 您将获得一个使用这三个可能值初始化的 m×n 2D 网格。
* -1 - 墙壁或障碍物。
* 0 - 门。
* INF - Infinity是一个空房间。我们使用值 2 ^ 31 - 1 = 2147483647 来表示INF，您可以假设到门的距离小于 2147483647。
* 在代表每个空房间的网格中填入到距离最近门的距离。如果不可能到达门口，则应填入 INF。
*
* 样例
* 给定 2D 网格：
*
* INF  -1  0  INF
* INF INF INF  -1
* INF  -1 INF  -1
*   0  -1 INF INF
* 返回结果：
*
*  3  -1   0   1
*  2   2   1  -1
*  1  -1   2  -1
*  0  -1   3   4
*
*
*  思路：将问题简化为，如果这个点是一个门，求这个门到其他所有点的最短路径
*
* */

package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class walls_and_gates {
    int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 优化queue里的object：原来是一个size为2的array来表示，这样占用了很多额外space
                // 在存进queue之后，只需要用 /n 与 %n 来获取i和j的值即可
                if (rooms[i][j] == 0) queue.add(i * n + j); // add all the gates to the queue
            }
        }
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int x = poll / n, y = poll % n;
            // check for directions
            for (int i = 0; i < direction.length; i++) {
                int newX = x + direction[i][0], newY = y + direction[i][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && rooms[newX][newY] == Integer.MAX_VALUE) {
                    rooms[newX][newY] = rooms[x][y] + 1;
                    queue.add(newX * n + newY);
                }
            }
        }
    }
}
