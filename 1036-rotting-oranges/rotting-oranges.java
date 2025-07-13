class Solution {
    int c = -1;

    public void bsf(int[][] mat) {
        ArrayList<int[]> arr = new ArrayList<>();

        // ✅ Add all rotten oranges (value == 2) to start BFS from
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 2) {
                    arr.add(new int[] { i, j });
                }
            }
        }

        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (arr.size() > 0) {
            int n = arr.size();
            c++; // ✅ Increase time for each level
            ArrayList<int[]> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = arr.get(i)[0];
                int y = arr.get(i)[1];

                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if (nx >= 0 && ny >= 0 && nx < mat.length && ny < mat[0].length && mat[nx][ny] == 1) {
                        mat[nx][ny] = 2; // ✅ Rot the fresh orange
                        temp.add(new int[] { nx, ny });
                    }
                }
            }

            arr = temp;
        }
    }

    public int orangesRotting(int[][] grid) {
        c = -1;
        bsf(grid);

        // ✅ Check if any fresh orange is left
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        // ✅ If no oranges needed to be rotted, return 0
        return c == -1 ? 0 : c;
    }
}
