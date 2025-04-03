
class Solution {
    public boolean help(TreeNode p, TreeNode q) {
        if (p == null && q != null)
            return false;
        if (p != null && q == null)
            return false;
        if (p == null && q == null)
            return true;
        if (p.val != q.val)
            return false;

        return help(p.left, q.left) && help(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return help(p, q);
    }
}