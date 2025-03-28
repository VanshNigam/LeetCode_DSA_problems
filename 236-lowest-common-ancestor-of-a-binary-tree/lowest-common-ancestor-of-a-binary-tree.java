class Solution {
    public TreeNode help(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;

        TreeNode l = help(root.left, p, q);
        TreeNode r = help(root.right, p, q);

        if (l != null && r != null)
            return root;
        else if (l != null)
            return l;
        return r;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return help(root, p, q);
    }
}