class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> mp = new TreeMap<>();

        int max = -1;

        for (int i : nums) {
            StringBuilder s = new StringBuilder(String.valueOf(i));
            int sum = 0;
            for (char c : s.toString().toCharArray()) {
                int x = Character.getNumericValue(c);
                sum += x;
            }
            if (!mp.containsKey(sum))
                mp.put(sum, new PriorityQueue<>((a, b) -> b - a));
            else
                max = Math.max(max, mp.get(sum).peek() + i);
            mp.get(sum).add(i);
        }
        return max;
    }
}