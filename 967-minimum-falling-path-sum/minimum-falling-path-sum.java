class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = 1000001;
        int dp[][] = new int[n][n];
        for(int []d:dp){
            Arrays.fill(d,1000001);
        }
        for(int j=0;j<n;j++){
            ans = Math.min(ans,recur(0,j,n,dp,matrix));
        }
        return ans;
    }
    private int recur(int r,int c,int n,int dp[][],int matrix[][]){
        if(c==n || c==-1) return 1000001;
        if(r== n-1){
            return matrix[r][c];
        }
        if(dp[r][c]!=1000001) return dp[r][c];
        int ans = 1000001;
        for(int i=-1;i<=1;i++){
           ans = Math.min(ans,recur(r+1,c+i,n,dp,matrix));
        }
        return dp[r][c] = matrix[r][c] + ans;

    }
}