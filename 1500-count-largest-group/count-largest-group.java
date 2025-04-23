class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> mp = new HashMap<>();
        int c = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int curr = i;
            while (curr > 0) {
                sum += curr % 10;
                curr = curr / 10;
            }
            int x = sum;
            mp.put(x, mp.getOrDefault(x,0)+ 1);
        }

        int max = 0;
        for (int i1 : mp.keySet()) {

            if (mp.get(i1) == max) 
                c++;
            else if (mp.get(i1) > max) {
                max = mp.get(i1);
                c = 1;
            }
        }
        return c;
    }
}