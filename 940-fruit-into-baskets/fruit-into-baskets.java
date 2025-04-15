class Solution {
    public int totalFruit(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();

        int l = 0;
        int r = 0;
        int n = arr.length, max = 0;

        while (l < n && r < n) {
            mp.put(arr[l], mp.getOrDefault(arr[l], 0) + 1);

            if (mp.size() > 2) {
                mp.put(arr[r], mp.get(arr[r]) - 1);
                if (mp.get(arr[r]) == 0) {
                    mp.remove(arr[r]);
                }
                r++;
            } else
                max = Math.max(max, l - r + 1);

            l++;

            // System.out.println(mp);
        }
        return max;
    }
}