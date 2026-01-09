class Solution {
    private int[][] memo;
    public int helper(List<List<Integer>> triangle, int x, int y) {
        if (x >= triangle.size()) return 0;
        if (memo[x][y] != Integer.MAX_VALUE) return memo[x][y];

        int temp = triangle.get(x).get(y) +
                Math.min(helper(triangle, x + 1, y), helper(triangle, x + 1, y + 1));

        memo[x][y] = temp;
        return temp;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, Integer.MAX_VALUE);

        return helper(triangle, 0, 0);
    }
}
