/*
*
* 450. Delete Node in a BST
* https://leetcode.com/problems/delete-node-in-a-bst/description/
* ----------------------------------------------------------------------------------------------------------------------
* Given a root node reference of a BST and a key, delete the node with the given key in the BST.
* Return the root node reference (possibly updated) of the BST.
*
* Basically, the deletion can be divided into two stages:
* Search for a node to remove.
* If the node is found, delete the node.
* Note: Time complexity should be O(height of tree).
*
* 例如：
* root = [5,3,6,2,4,null,7]
* key = 3
*
*     5
*    / \
*   3   6
*  / \   \
* 2   4   7
*
* 思路：两种删的方式
* 1. 将left child里的right-most leaf往上放
* 2. 将right child里的left-most leaf往上放
*
* steps:
* 1. Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
* 2. Once the node is found, have to handle the below 4 cases
*   (1) node doesn’t have left or right - return null
*   (2) node only has left subtree - return the left subtree
*   (3) node only has right subtree - return the right subtree
*   (4) node has both left and right - find the minimum value in the right subtree,
*       set that value to the currently found node, then recursively delete the minimum value in the right subtree
*
* */

package trees.BST;

public class delete_node_in_a_BST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else if (root.val < key) root.right = deleteNode(root.right, key);
        else { // root.val == key
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else { // both children are not null
                TreeNode min = findRightMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private TreeNode findRightMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
