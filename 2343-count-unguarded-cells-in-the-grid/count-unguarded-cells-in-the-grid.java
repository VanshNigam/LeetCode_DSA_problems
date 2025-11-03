class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int a[][] = new int[m][n];

        for (int i = 0; i < walls.length; i++) {
            a[walls[i][0]][walls[i][1]] = 2;
        }
        for (int i = 0; i < guards.length; i++) {
            a[guards[i][0]][guards[i][1]] = 3;
        }

        for (int i = 0; i < guards.length; i++) {
            int x = guards[i][0];
            int y = guards[i][1];
            // Right movement
            while (y < n - 1 && a[x][y + 1] != 2 && a[x][y + 1] != 3) {
                y++;
                a[x][y] = 1; // right
            }
            y = guards[i][1];

            // Left movement
            while (y > 0 && a[x][y - 1] != 2 && a[x][y - 1] != 3) {
                y--;
                a[x][y] = 1; // left
            }
            y = guards[i][1];

            // Downward movement
            while (x < m - 1 && a[x + 1][y] != 2 && a[x + 1][y] != 3) {
                x++;
                a[x][y] = 1; // down
            }
            x = guards[i][0];

            // Upward movement
            while (x > 0 && a[x - 1][y] != 2 && a[x - 1][y] != 3) {
                x--;
                a[x][y] = 1; // up
            }

        }
        int c = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0)
                    c++;
                // System.out.print(a[i][j] + " ");
            }
            // System.out.println();
        }
        return c;

    }
}