class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
       int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1||grid[n-1][m-1]==1)return -1;
        if(n==1 && m==1 && grid[0][0]==0)return 1;
        int res=1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        while(!q.isEmpty()){
            int qsize = q.size();
            for(int i=0;i<qsize;i++){
                int[] arr = q.poll();
                
                for(int j=0;j<8;j++){
                    int newx = arr[0]+directions[j][0];
                    int newy = arr[1]+directions[j][1];
                    
                    if(newx<0||newy<0||newx>=n||newy>=m||grid[newx][newy]==1)continue;
                    if(newx==n-1 && newy==m-1) return res+1;
                    grid[newx][newy] = 1;
                    q.add(new int[]{newx,newy});
                }
            }
            res++;
        }
        
        return -1;
    }
}