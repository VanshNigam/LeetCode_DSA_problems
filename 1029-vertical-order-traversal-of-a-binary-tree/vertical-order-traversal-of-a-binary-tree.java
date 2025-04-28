class Tuple {
    TreeNode node; int row, col;
    Tuple(TreeNode n, int r, int c) { node = n; row = r; col = c; }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>(); q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            map.computeIfAbsent(t.row, x -> new TreeMap<>())
               .computeIfAbsent(t.col, y -> new PriorityQueue<>())
               .offer(t.node.val);
            if (t.node.left != null) q.offer(new Tuple(t.node.left, t.row - 1, t.col + 1));
            if (t.node.right != null) q.offer(new Tuple(t.node.right, t.row + 1, t.col + 1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        map.values().forEach(ys -> {
            List<Integer> temp = new ArrayList<>();
            ys.values().forEach(pq -> { while (!pq.isEmpty()) temp.add(pq.poll()); });
            ans.add(temp);
        });
        return ans;
    }
}
