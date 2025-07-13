class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        ArrayList<int[]> arr = new ArrayList<>();
        if (image[sr][sc] == color) return image;

        arr.add(new int[] { sr, sc });
        int currColor=image[sr][sc];
        image[sr][sc] = color;

        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (arr.size() > 0) {
            ArrayList<int[]> temp = new ArrayList<>();
            int n = arr.size();

            for (int ind = 0; ind < n; ind++) {
                for (int i[] : dir) {
                    int x = arr.get(ind)[0] + i[0];
                    int y = arr.get(ind)[1] + i[1];
                    if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y]==currColor) {
                        temp.add(new int[] { x, y });
                        image[x][y] = color;
                    }
                }
            }
            arr = temp;
        }
        return image;
    }
}