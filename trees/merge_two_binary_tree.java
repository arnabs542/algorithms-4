/*
*
* 617. Merge Two Binary Trees
* https://leetcode.com/problems/merge-two-binary-trees/description/
*
* Input:
*  	Tree 1                     Tree 2
*          1                         2
*         / \                       / \
*        3   2                     1   3
*       /                           \   \
*      5                             4   7
* Output:
* Merged tree:
*	     3
*	    / \
*	   4   5
*	  / \   \
*	 5   4   7
*
* */

//package trees;
//
//import java.util.Stack;
//
//public class merge_two_binary_tree {
//    /*recursive solution*/
//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) return null;
//        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
//        TreeNode newNode = new TreeNode(val);
//
//    }
//}
