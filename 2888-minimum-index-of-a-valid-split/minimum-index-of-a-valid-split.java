class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        int el = nums.get(0);
        int c = 0;

        for (int i = 1; i < n; i++) {
            int x = nums.get(i);
            if (c == 0) {
                c = 1;
                el = x;
            } else if (x == el)
                c += 1;
            else if (x != el)
                c -= 1;
        }
        c = 0;
        for (int a : nums)
            if (a == el)
                c += 1;

        int curr = 0;
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            if (el == x)
                curr += 1;
            if ((curr > (i + 1) / 2) && (c - curr) > (n - i - 1) / 2) {
                return i;
            }
        }
        return -1;
    }
}