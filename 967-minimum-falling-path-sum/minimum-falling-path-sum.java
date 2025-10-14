class Solution {
    // public int helper(int[][] grid, int x, int y, int dp[][]) {
    //     if (grid[0].length <= y || y < 0)
    //         return Integer.MAX_VALUE;

    //     if (x == grid.length - 1)
    //         return grid[x][y];

    //     if (dp[x][y] != Integer.MAX_VALUE)
    //         return dp[x][y];
    //     int back = helper(grid, x + 1, y - 1, dp); // diagonal left-down
    //     int down = helper(grid, x + 1, y, dp); // straight down
    //     int forw = helper(grid, x + 1, y + 1, dp); // diagonal right-down

    //     int temp = Math.min(back, Math.min(down, forw)); // take minimum among 3 options

    //     dp[x][y] = grid[x][y] + temp;
    //     return dp[x][y];
    // }

    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        int n=grid.length;

        for(int i=0;i<n;i++){
            dp[n-1][i]=grid[n-1][i];
        }

        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int back = (j>0 ) ? dp[i+1][j-1] : Integer.MAX_VALUE; 
                int down = dp[i+1][j] ;
                int forw = (j<n-1) ? dp[i+1][j+1] : Integer.MAX_VALUE ;

                int temp = Math.min(back, Math.min(down, forw));
                dp[i][j] = grid[i][j] + temp; 
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,dp[0][i]);
        }
        return min;
    }
}