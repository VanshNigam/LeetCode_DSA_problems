class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int curr = 0;
        Map<Integer , Integer> m = new HashMap<>();
        m.put(0,1);
        for (int i : nums){
           curr += i;
           int d = curr - goal;
           if (m.containsKey(d)){
            count += m.get(d);
           }
         m.put(curr,m.getOrDefault(curr,0)+1);
        }
        return count;
    }
}