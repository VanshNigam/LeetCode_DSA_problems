class Solution {
    public void help(TreeNode root){
        if(root==null)return;

        TreeNode temp=root.right;
        root.right=root.left;
        root.left=temp;

        help(root.left);
        help(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        help(root);
        return root;
    }
}