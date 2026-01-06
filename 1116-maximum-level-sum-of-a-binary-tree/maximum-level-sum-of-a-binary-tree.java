class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        long max = Integer.MIN_VALUE;
        int c = 0;
        int ans = 0;

        while (!q.isEmpty()) {
            int l = q.size();
            long curr = 0;
            c++;
            for (int i = 0; i < l; i++) {
                TreeNode p = q.poll();
                curr += p.val;
                if (p.left != null)
                    q.add(p.left);
                if (p.right != null)
                    q.add(p.right);
            }
            if (curr > max) {
                max = curr;
                ans = c;
            }
        }
        return ans;
    }
}