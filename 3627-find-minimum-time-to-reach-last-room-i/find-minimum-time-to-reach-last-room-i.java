public class Solution 
{
    public int minTimeToReach(int[][] moveTime) 
    {
        int m = moveTime.length;
        int n = moveTime[0].length;

        // Step 1: Initialize distance matrix with max values
        int[][] dist = new int[m][n];
        for (int[] row : dist) 
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        dist[0][0] = 0; // Starting point at time 0

        // Step 2: Priority queue to always pick the cell with minimum arrival time
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0}); // Format: {row, col, currentTime}

        // Step 3: Directions for moving in 4 directions (up, down, left, right)
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 4: Main loop to process the queue
        while (!pq.isEmpty()) 
        {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int time = curr[2];

            // Step 5: Check if destination is reached
            if (x == m - 1 && y == n - 1) 
            {
                return time;
            }

            // Step 6: Explore all 4 neighbors
            for (int[] dir : dirs) 
            {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) 
                {
                    // Step 7: Compute the wait time if current time is too early
                    int waitTime = Math.max(0, moveTime[nx][ny] - time);
                    int arriveTime = time + 1 + waitTime;

                    // Step 8: If this path is faster, update and add to queue
                    if (arriveTime < dist[nx][ny]) 
                    {
                        dist[nx][ny] = arriveTime;
                        pq.offer(new int[]{nx, ny, arriveTime});
                    }
                }
            }
        }

        // Step 9: Destination unreachable
        return -1;
    }
}