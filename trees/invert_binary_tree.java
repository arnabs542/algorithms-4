package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class invert_binary_tree {

    /*
    * recursive DFS
    * */
    // with helper method
    public TreeNode invertTreeRecursive(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
    }

    // without helper method
    public TreeNode invertTreeRecursive2(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left, right = root.right;
        root.left = invertTreeRecursive2(right);
        root.right = invertTreeRecursive2(left);
        return root;
    }

    /*
    * Iterative BFS solution
    * */
    public TreeNode invertTreeIterativeBFS(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }

    /*
    * Iterative DFS solution
    * */
    public TreeNode invertTreeIterativeDFS(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return root;
    }
}
