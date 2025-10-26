class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer>mp=new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode t = q.poll();
                if (mp.contains(k - t.val))
                    return true;
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
                mp.add(t.val);
            }
        }
        return false;
    }
}