/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private TreeNode invert(TreeNode node) {
        if (node == null) return node;

        TreeNode right = node.right;
        node.right = invert(node.left);
        node.left = invert(right);

        return node;
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        return invert(root);
    }
}
