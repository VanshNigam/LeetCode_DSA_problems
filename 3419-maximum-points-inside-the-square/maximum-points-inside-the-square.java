class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        TreeMap<Integer, StringBuilder> mpp = new TreeMap<>();
        int ma = 0;

        for (int i = 0; i < points.length; ++i) {
            int x = Math.abs(points[i][0]);
            int y = Math.abs(points[i][1]);
            int dist = Math.max(x, y);
            mpp.putIfAbsent(dist, new StringBuilder());
            mpp.get(dist).append(s.charAt(i));
        }

        int[] count = new int[26];
        for (Map.Entry<Integer, StringBuilder> entry : mpp.entrySet()) {
            boolean flag = true;
            for (char ch : entry.getValue().toString().toCharArray()) {
                count[ch - 'a']++;
                if (count[ch - 'a'] > 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ma += entry.getValue().length();
            } else break;
        }
        return ma;
    }
}
