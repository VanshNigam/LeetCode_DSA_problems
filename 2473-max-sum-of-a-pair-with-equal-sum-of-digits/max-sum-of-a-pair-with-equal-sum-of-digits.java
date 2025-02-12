class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> mp = new TreeMap<>();
        // Array.sort(nums);
        int max=-1;

        for (int i : nums) {
            String s = i + "";
            int sum = 0;
            for (char c : s.toCharArray()) {
                int x = Integer.parseInt(c + "");
                sum += x;
            }
            if (!mp.containsKey(sum))
                mp.put(sum, new PriorityQueue<>((a, b) -> b - a));
            else
                max = Math.max(max,mp.get(sum).peek() + i);
            mp.get(sum).add(i);

        }
        // System.out.println(mp);
        return max;
    }
}