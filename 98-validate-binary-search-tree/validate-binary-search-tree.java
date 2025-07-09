class Solution {
    boolean help(TreeNode r, Long min, Long max) {
        if (r == null)
            return true;
        if (r.val <= min || r.val >= max)
            return false;
        return help(r.left, min, (long)r.val) && help(r.right, (long)r.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}