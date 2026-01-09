class Solution {
    public TreeNode help(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p ||root==q)return root;
        TreeNode left=help(root.left,p,q);
        TreeNode right=help(root.right,p,q);

        if(left==null)return right;
        if(right==null)return left;
        // if both not null
        return root;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<TreeNode> arr = new ArrayList<>();
        if (root == null)
            return root;
        q.add(root);
        while (!q.isEmpty()) {
            ArrayList<TreeNode> curr = new ArrayList<>();
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode p = q.poll();
                if (p.left != null)
                    q.add(p.left);
                if (p.right != null)
                    q.add(p.right);
                curr.add(p);
            }
            arr = curr;
        }
        TreeNode i = arr.get(0);
        TreeNode j = arr.get(arr.size() - 1);

        if (arr.size() == 1)
            return i;
        return help(root, i, j);
    }
}