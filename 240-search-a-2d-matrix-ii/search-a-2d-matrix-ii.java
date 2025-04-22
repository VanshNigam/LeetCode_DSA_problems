class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int j=matrix[0].length-1;
        int i=0;
        while(i<matrix.length && j>-1){
            if(matrix[i][j]==target)return true;
            else if(matrix[i][j]<target)i++;
            else j--;
        }
        return false;
    }
}