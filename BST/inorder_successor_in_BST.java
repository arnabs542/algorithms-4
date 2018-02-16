/*
*
* 285. Inorder Successor in BST
* https://leetcode.com/problems/inorder-successor-in-bst/description/
* Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
*
* 两种情况：
*   1. root.val <= p.val，答案在右子树中
*   2. root.val > p.val，答案在左子树中，或者答案是root（p为左子树中最靠右的leaf）
*
* */

package BST;

public class inorder_successor_in_BST {
    /*recursive solution*/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        if (root.val <= p.val) return inorderSuccessor(root.right, p);
        else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }

    /*iterative solution*/
    public TreeNode inorderSuccessor_iterative(TreeNode root, TreeNode p) {
        // 因为succ有可能是root，所以用一个pointer来存它
        TreeNode succ = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                succ = root;
                root = root.right;
            }
        }
        return succ;
    }
}
