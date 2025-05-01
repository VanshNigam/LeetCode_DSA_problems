class Solution {
    public void build(Map<TreeNode, TreeNode> mp, TreeNode r) {
        if (r == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(r);

        while (!q.isEmpty()) {
            TreeNode p = q.poll();

            if (p.left != null) {
                q.offer(p.left);
                mp.put(p.left, p);
            }
            if (p.right != null) {
                q.offer(p.right);
                mp.put(p.right, p);
            }
        }
    }

    public List<Integer> findAtKth(TreeNode target, int k, Map<TreeNode, TreeNode> mp) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> vis = new HashSet<>();
        int curr = 0;
        q.offer(target);
        vis.add(target);

        while (!q.isEmpty()) {
            if (curr == k) {
                for (TreeNode node : q) {
                    res.add(node.val);
                }
                return res;
            }
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode p = q.poll();

                if (p.left != null && !vis.contains(p.left)) {
                    q.offer(p.left);
                    vis.add(p.left);
                }
                if (p.right != null && !vis.contains(p.right)) {
                    q.offer(p.right);
                    vis.add(p.right);
                }
                if (mp.containsKey(p) && !vis.contains(mp.get(p))) {
                    q.offer(mp.get(p));
                    vis.add(mp.get(p));
                }
            }
            curr++;
        }
        return res;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> mp = new HashMap<>();

        build(mp, root);
        List<Integer> res = findAtKth(target, k, mp);

        return res;
    }
}