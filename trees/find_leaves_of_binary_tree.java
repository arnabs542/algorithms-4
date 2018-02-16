/*
*
* 366. Find Leaves of Binary Tree
* https://leetcode.com/problems/find-leaves-of-binary-tree/description/
* http://www.lintcode.com/zh-cn/problem/binary-tree-leaves-order-traversal/
*
* 给定一个二叉树，像这样收集树节点：收集并移除所有叶子，重复，直到树为空。
*
*            1
*          / \
*         2   3
*        / \
*       4   5
*
* 返回 [[4, 5, 3], [2], [1]]
*
* 剥开的顺序的规律：第k层包含的就是所有高度为k的节点
*
*
*            1[3]
*          /    \
*         2[2]  3[1]
*        /    \
*       4[1]   5[1]
*
* DFS计算节点高度，hash保存答案
* */

package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class find_leaves_of_binary_tree {
    Map<Integer, List<Integer>> depthMap = new HashMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int maxDepth = dfs(root);
        for (int i = 1; i <= maxDepth; i++) {
            result.add(depthMap.get(i));
        }
        return result;
    }

    int dfs(TreeNode node) {
        if (node == null) return 0;
        // 用variable 来存current node的depth，然后放入map
        int depth = Math.max(dfs(node.left), dfs(node.right)) + 1;
        depthMap.putIfAbsent(depth, new ArrayList<>());
        depthMap.get(depth).add(node.val);
        return depth;
    }
}
