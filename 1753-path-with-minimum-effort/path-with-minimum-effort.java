class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;

        int[][] diff = new int[n][m];
        for (int[] row : diff) Arrays.fill(row, Integer.MAX_VALUE);
        diff[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.add(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (curr.x == n-1 && curr.y == m-1) return curr.dist; 

            if (curr.dist > diff[curr.x][curr.y]) continue;

            for (int[] d : dirs) {
                int nx = curr.x + d[0], ny = curr.y + d[1];
                if (nx>=0 && nx<n && ny>=0 && ny<m) {
                    int new_effort = Math.max(curr.dist,
                        Math.abs(heights[nx][ny] - heights[curr.x][curr.y]));
                    if (new_effort < diff[nx][ny]) {
                        diff[nx][ny] = new_effort;
                        pq.add(new Pair(nx, ny, new_effort));
                    }
                }
            }
        }
        return diff[n-1][m-1];
    }
}

class Pair {
    int x, y, dist;
    Pair(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}