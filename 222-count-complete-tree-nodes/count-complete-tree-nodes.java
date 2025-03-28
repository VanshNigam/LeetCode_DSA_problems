
class Solution {
    public int help(TreeNode r){
        if(r==null)return 0;
        return help(r.left)+help(r.right)+1;
    }
    public int countNodes(TreeNode root) {
        return help(root);
    }
}