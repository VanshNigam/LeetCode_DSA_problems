class Solution {
    public int[][] sortMatrix(int[][] a) {
        int m = a.length, n = a[0].length;
        Map<Integer, PriorityQueue<Integer>> mp1 = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> mp2 = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i + 1; j++) {
                int diff = i - j;
                mp1.putIfAbsent(diff, new PriorityQueue<>(Collections.reverseOrder()));
                mp1.get(diff).add(a[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = i - j;
                mp2.putIfAbsent(diff, new PriorityQueue<>());
                mp2.get(diff).add(a[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i + 1; j++) {
                int diff = i - j;
                a[i][j] = mp1.get(diff).poll();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = i - j;
                a[i][j] = mp2.get(diff).poll();
            }
        }
        return a;
    }
}