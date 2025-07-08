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
    public boolean help(TreeNode r, int t) {
        if (r == null )
            return false;
        if (t == r.val && r.left == null && r.right == null)
            return true;

        boolean left = false;
        if (r.left != null)
            left = help(r.left, t - r.val);
        boolean right = false;
        if (r.right != null)
            right = help(r.right, t - r.val);

        return left || right;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return help(root, targetSum);
    }
}