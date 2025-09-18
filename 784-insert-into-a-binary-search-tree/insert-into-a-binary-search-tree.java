class Solution {
    public TreeNode help(TreeNode root, int val) {
        if (root == null) {
            TreeNode temp = new TreeNode(val);
            return temp;
        }
        if (root.val > val)
            root.left = help(root.left, val);
        else
            root.right = help(root.right, val);
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        return help(root, val);
    }
}