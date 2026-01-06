
class Solution {
    public boolean isBalanced(TreeNode root) {
        return isbal(root) != -1;
    }

    int isbal(TreeNode root) {
        if (root == null) return 0;

        int lh = isbal(root.left);
        if (lh == -1) return -1;

        int rh = isbal(root.right);
        if (rh == -1) return -1;

        int temp=Math.abs(lh - rh);
        if (temp > 1) 
            return -1;
        else
            return Math.max(lh, rh) + 1;
    }
}