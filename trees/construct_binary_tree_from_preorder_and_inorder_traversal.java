/*
*
* 105. Construct Binary Tree from Preorder and Inorder Traversal
* https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
* ----------------------------------------------------------------------------------------------------------------------
* Given preorder and inorder traversal of a tree, construct the binary tree.
*
* Note:
* You may assume that duplicates do not exist in the tree.
*
* For example, given
*
* preorder = [3,9,20,15,7]
* inorder = [9,3,15,20,7]
* Return the following binary tree:
*
*     3
*    / \
*   9  20
*     /  \
*    15   7
*
* 思路：
* 1. preorder: 根左右
* 2. inorder: 左根右
*
* 观察：
* 1. preorder第一个元素是root
* 2. 通过preorder找到了root之后，root左边的元素是left children，root右边的元素是right children
* 2. 所以通过preorder来确定root，通过inorder来build tree structure
* */

package trees;

import java.util.Arrays;

public class construct_binary_tree_from_preorder_and_inorder_traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    // pre: 找root, in: 建树
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i=inStart; i<=inEnd; i++) {
            if(inorder[i] == root.val){
                inIndex = i;
                break;
            }
        }

        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // right的preStart的index是之前的index + inorder左边的区间的长度 + 1
        root.right = helper(preStart + (inIndex - inStart + 1), inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
