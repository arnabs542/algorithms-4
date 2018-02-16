package union_find;

import java.util.*;

public class redundant_connection_ii {
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] temp1 = {-1, -1}, temp2 = {-1, -1};
        int[] parents = new int[n + 1]; // parents, 不是roots
        for (int[] edge : edges) {
            if (parents[edge[1]] == 0) { // 如果edge还没有设置parent
                parents[edge[1]] = edge[0];
            } else {
                temp1 = new int[] {parents[edge[1]], edge[1]};
                temp2 = new int[] {edge[0], edge[1]};
                edge[1] = 0; // making the current edge invalid
            }
        }
        for (int i = 1; i < n+1; i++) { // union find之前，将每个node的parent设置为自己
            parents[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[1] == 0) { // 如果node是invalid，直接跳过
                continue;
            }
            int child = edge[1], father = edge[0];
            if (findRoot(parents, father) == child) { // 如果有循环
                if (temp1[0] == -1) { // 有循环，而且之前并没有哪个node有两个parent
                    return edge;
                }
                else return temp1; // 有循环，而且之前有node有两个parent
            }
            parents[child] = father;
        }
        return temp2;
    }

    static int findRoot(int[] parents, int i) {
        while (i != parents[i]) {
            i = parents[i];
        }
        return i;
    }

    public static void main(String[] args) {
//        int[][] edges = {{3,4},{4,1},{1,2},{2,3},{5,1}};
        int[][] edges = {{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(findRedundantDirectedConnection(edges)));
    }
}
