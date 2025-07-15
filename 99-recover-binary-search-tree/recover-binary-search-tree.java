class Solution {
    TreeNode prev = null, first = null, second = null;

    public void help(TreeNode r) {
        if (r == null)
            return;
        help(r.left);
        if (prev != null && prev.val > r.val) {
            if (first == null) {
                first = prev;
            }
            second = r;
        }
        prev = r;
        help(r.right);
    }

    public void recoverTree(TreeNode root) {
        help(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}