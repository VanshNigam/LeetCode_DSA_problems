class Solution {
    public int maxDistance(String s, int k) {
        int x = 0;
        int y = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'E') x += 1;
            if (c == 'W') x -= 1;
            if (c == 'N') y += 1;
            if (c == 'S') y -= 1;
            max = Math.max(max, Math.min(Math.abs(x) + Math.abs(y) + k * 2, i + 1));
        }
        return max;
    }
}
