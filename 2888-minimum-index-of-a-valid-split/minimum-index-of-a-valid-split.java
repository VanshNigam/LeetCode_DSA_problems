class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size(), count = 0, res = 0, target = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            int cur = map.getOrDefault(num, 0) + 1;
            map.put(num, cur);
            if(cur > count) {
                target = num;
                count = cur;
            }
        }

        int left = 0;
        for(int i = 0; i < n; i++) {
            if(nums.get(i) == target) {
                left++;
            }
            
            if(left * 2 > (i + 1) && (count - left) * 2 > (n - i - 1)) {
                return i;
            }
        }

        return -1;
    }
}