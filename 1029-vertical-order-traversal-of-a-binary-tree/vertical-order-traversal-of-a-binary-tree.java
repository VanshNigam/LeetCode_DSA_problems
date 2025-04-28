    class Pair {
        TreeNode node;
        int hd, level;
        Pair(TreeNode node, int hd, int level) {
            this.node = node;
            this.hd = hd;
            this.level = level;
        }
    }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap to store: hd -> (level -> nodes sorted)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        // Queue for BFS traversal (node, horizontal distance, level)
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0)); // root at hd = 0, level = 0

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int hd = p.hd, level = p.level;

            // Create map entries if not exist
            map.putIfAbsent(hd, new TreeMap<>());
            map.get(hd).putIfAbsent(level, new PriorityQueue<>());

            // Add node value into map
            map.get(hd).get(level).offer(node.val);

            // Traverse left and right children with updated hd and level
            if (node.left != null) q.offer(new Pair(node.left, hd - 1, level + 1));
            if (node.right != null) q.offer(new Pair(node.right, hd + 1, level + 1));
        }

        // Prepare final result
        List<List<Integer>> result = new ArrayList<>();
        for (Integer hd : map.keySet()) {
            List<Integer> col = new ArrayList<>();
            
            for (Integer level : map.get(hd).keySet()) {
                PriorityQueue<Integer> pq = map.get(hd).get(level);
                
                while (!pq.isEmpty()) {
                    col.add(pq.poll());
                }
            }
            result.add(col);
        }
        return result;
    }

    // Pair class to hold node with its horizontal distance and level
}