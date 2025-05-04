class Solution {
    public int numEquivDominoPairs(int[][] arr) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i[] : arr) {
            int a = Math.min(i[0], i[1]);
            int b = Math.max(i[0], i[1]);

            mp.put(10 * a + b, mp.getOrDefault(10 * a + b, 0) + 1);
        }

        int pair = 0;
        for (int i : mp.keySet()) {
            if (mp.get(i) > 1)
                pair += (mp.get(i) * (mp.get(i) - 1))/2;
        }
        return pair;
    }
}