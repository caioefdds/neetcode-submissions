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
    private int checkNodes(TreeNode node) {
        if (node == null) return 0;

        int left = checkNodes(node.left);
        int right = checkNodes(node.right);
        int diff = Math.abs(left - right);

        // System.out.println(diff);

        if (left == -1 || right == -1 || diff > 1) return -1;

        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        return checkNodes(root) != -1;
    }
}
