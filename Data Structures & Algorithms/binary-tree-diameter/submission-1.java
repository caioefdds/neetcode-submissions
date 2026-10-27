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
    private int maxDiameter = 0;

    private int diameter(TreeNode node) {
        if (node == null) return 0;
        int left = diameter(node.left);
        int right = diameter(node.right);

        maxDiameter = Math.max(maxDiameter, right + left);

        return Math.max(left, right) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        diameter(root);
        return maxDiameter;
    }
}
