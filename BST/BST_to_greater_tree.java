/*
*
* 538. Convert BST to Greater Tree
* https://leetcode.com/problems/convert-bst-to-greater-tree/description/
* greater tree的定义：一个node变成>=该node值的“所有node值的和”
* 思路：right -> parent -> left，反inorder traversal
*
* */

package BST;

import java.util.Stack;

public class BST_to_greater_tree {

    /*recursive method*/
    // right -> parent -> left
    public TreeNode convertBST(TreeNode root) {
        recursiveDFS(root);
        return root;
    }

    int sum = 0;
    public void recursiveDFS(TreeNode node) {
        if (node == null) return;
        recursiveDFS(node.right);
        sum += node.val;
        node.val = sum;
        recursiveDFS(node.left);
    }

    /*iterative method, stack*/
    public TreeNode convertBST_iterative(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int sum = 0;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }
}
