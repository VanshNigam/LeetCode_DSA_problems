class Solution {
    public TreeNode  insert(TreeNode r, int val) {
        if (r == null) {
            TreeNode temp=new TreeNode(val);
            return temp;
        }
        if (r.val < val) {
            r.right=insert(r.right, val);
        } else if (r.val > val) {
            r.left=insert(r.left, val);
        }
        return r;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }
}