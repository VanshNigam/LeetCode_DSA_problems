class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> mp = new TreeMap<>();
        int max = -1;

        for (int i : nums) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (!mp.containsKey(sum)) {
                mp.put(sum, new PriorityQueue<>((a, b) -> b - a));
            } else {
                if (!mp.get(sum).isEmpty()) {
                    max = Math.max(max, mp.get(sum).peek() + i);
                }
            }
            mp.get(sum).add(i);
        }
        return max;
    }
}
