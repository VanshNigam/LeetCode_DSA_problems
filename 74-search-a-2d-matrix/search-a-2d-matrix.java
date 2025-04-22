class Solution {

    public boolean help(int j, int k, int[][] mat) {
        int l = 0;
        int r = mat[0].length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (mat[j][mid] == k)
                return true;
            else if (mat[j][mid] < k)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int l = 0;
        int r = matrix.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (matrix[mid][0] < target) {
                if (target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]) {
                    return help(mid, target, matrix);
                } else {
                    l = mid + 1;
                }
            } else if (matrix[mid][0] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}