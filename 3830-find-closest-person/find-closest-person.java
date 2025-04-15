class Solution {
    public int findClosest(int x, int y, int z) {
        int diff = Math.abs(z - x);
        int diff2 = Math.abs(z - y);

        if (diff == diff2)
            return 0;
        return diff > diff2 ? 2 : 1;
    }
}