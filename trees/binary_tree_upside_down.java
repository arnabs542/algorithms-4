/*
*
* 156. Binary Tree Upside Down
* https://leetcode.com/problems/binary-tree-upside-down/description/
*
* Given a binary tree where all the [right nodes are either leaf nodes with a sibling
* (a left node that shares the same parent node) or empty], flip it upside down and turn it into a tree
* where the original right nodes turned into left leaf nodes. Return the new root.
*
* example:
*      1
*    / \
*   2   3
*  / \
* 4   5
*
* 画出来之后是这样：
*
*      1
*    /
*   2---3
*  /
* 4---5
*
* 4是新的root
* */

package trees;

public class binary_tree_upside_down {
    TreeNode result;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return result;
    }

    void dfs(TreeNode node) {
        if (node.left == null) {
            result = node;
            return;
        }
        dfs(node.left);
        node.left.left = node.right;
        node.left.right = node;
        node.left = null;
        node.right = null;
    }

    public TreeNode upsideDownBinaryTree_iterative(TreeNode root) {
        TreeNode curr = root, next = null, prev = null, temp = null;
        while (curr != null) {
            next = curr.left;
            // swapping nodes now, need temp to keep the previous right child
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
