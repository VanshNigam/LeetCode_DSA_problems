// class Solution {
//     public int countSquares(int[][] mat) {
//         int n=mat.length;
//         int m=mat[0].length;

//         int dp[][]=new int[n][m];

//         for(int i=0;i<m;i++)dp[0][i]=mat[0][i];
//         for(int i=0;i<n;i++)dp[i][0]=mat[i][0];

//         for(int i=1;i<n;i++){
//             for(int j=1;j<m;j++){
//                 if(mat[i][j]==0)dp[i][j]=0;
//                 else{
//                     // min of up,left,diagonal
//                     dp[i][j]=Math.min(dp[i-1][j-1],
//                                 Math.min(dp[i-1][j],dp[i][j-1]))+1;
//                 }
//             }
//         }
//         //total sum of how many squares they can make
//         int sum=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 sum+=dp[i][j];
//             }
//         }
//         return sum;
//     }
// }

// ----------------------------------------------------
class Solution {
    public int countSquares(int[][] matrix) {
        // Get the dimensions of the matrix (number of rows and columns)
        int rows = matrix.length; 
        int cols = matrix[0].length; 
        
        // Initialize the counter for all the squares we can find
        int count = 0; 

        // Main logic: Look at the other elements to see how big of a square can we build until this point
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // If the current element is 1, it means we can potentially build a square
                if (matrix[i][j] == 1) {
                    // Find the minimum value of the top, left, and top-left diagonal neighbors
                    // and add 1 to it. This tells us the size of the biggest square we can make
/*
Imagine that you are building squares from units in a matrix. You want to find out which is the largest square you can build so that it ends in each cell.

**Briefly:**

* Look at the cell from above, on the left and diagonally.
* Take the smallest square size from these cells.
* Add 1 (if the current cell is also a unit). This will be the size of the largest square that ends in the current cell.

**Example:**

[
  [1, 1, 1],
  [1, 1, 1],
  [1, 1, 1]
]

You're in a cage `[1][1]'.

* Top: 1x1 square
* On the left: 1x1 square
* Diagonal: 1x1 square

The smallest size: 1. Add 1 (because the current cell is also 1). We get 2. This means that the largest square that ends in the cell is `[1][1]`, — this is a 2x2 square.
*/
                    matrix[i][j] = Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1])) + 1;
                }
            }
        }

        // Add the size of all the squares we found to the count
        // Now, loop through all the matrix to add all the valid square sizes.
        for (int i = 0; i < rows; i++) for (int j = 0; j < cols; j++) count += matrix[i][j];

        // All Done! Return total number of squares that exist in the matrix
        return count;
    }
}