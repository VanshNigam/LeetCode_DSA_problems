class Solution {
    int sum = 0;

    public void help(TreeNode r) {
        if (r == null)
            return ;

        help(r.right);
        sum += r.val;
        r.val = sum;
        help(r.left);
    }

    public TreeNode convertBST(TreeNode root) {
        help(root);
        return root;
    }
}