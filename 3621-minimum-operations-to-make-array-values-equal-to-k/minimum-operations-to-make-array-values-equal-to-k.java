class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (num < k) {
                return -1; 
            }
            if (num >= k) {
                set.add(num);
            }
        }

        int operations = set.size() - 1;

        if (!set.contains(k)) {
            operations++;
        }

        return operations;
    }
}