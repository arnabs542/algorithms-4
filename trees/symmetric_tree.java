/*
* LC 101. Symmetric Tree
* https://leetcode.com/problems/symmetric-tree/description/
*
* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
*
* */

package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class symmetric_tree {
    /*
    * recursive DFS
    * */
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    /*
    * iterative DFS
    * */
//    public boolean isSymmetricIterativeDFS(TreeNode root) {
//        if (root == null) return true;
//        Stack<TreeNode> stack = new Stack<>();
//        if (root.left)
//        while (!stack.isEmpty()) {
//            if (stack.size() == 1) {
//                TreeNode node = stack.pop();
//                stack.push(node.left);
//                stack.push(node.right);
//            } else {
//                TreeNode left = stack.pop();
//                TreeNode right = stack.pop();
//                if (left.val != right.val) return false;
//                stack.push(left.left);
//                stack.push(right.right);
//                stack.push(left.right);
//                stack.push(right.left);
//            }
//
//
//        }
//    }
}
