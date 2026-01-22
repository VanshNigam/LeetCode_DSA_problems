class Solution {
    public int countSquares(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int dp[][]=new int[n][m];

        for(int i=0;i<m;i++)dp[0][i]=mat[0][i];
        for(int i=0;i<n;i++)dp[i][0]=mat[i][0];

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j]==0)dp[i][j]=0;
                else{
                    // min of up,left,diagonal
                    dp[i][j]=Math.min(dp[i-1][j-1],
                                Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        //total sum of how many squares they can make
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=dp[i][j];
            }
        }
        return sum;
    }
}