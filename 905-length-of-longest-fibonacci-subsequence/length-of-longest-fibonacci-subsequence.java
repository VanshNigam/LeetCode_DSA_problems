class Solution {
    public int find(int a, int b, HashMap<Integer, Integer> mp) {
        int c = 2;

        while (mp.containsKey(a + b)) {
            c++;
            int temp = a + b;
            a = b;
            b = temp;
        }
        return c;
    }

    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i : arr)
            mp.put(i, 0);
        int max = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(find(arr[i], arr[j], mp), max);
            }
        }

        return max > 2 ? max : 0;
    }
}