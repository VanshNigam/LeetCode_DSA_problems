class Solution {
    public int gcd(int x, int y) {
        int x1 = Math.max(x, y);
        int y1 = Math.min(x, y);
        while (y1 != 0) {
            int t = x1 % y1;
            x1 = y1;
            y1 = t;
        }
        return x1;
    }

    public int subarrayGCD(int[] nums, int k) {
        int c = 0;

        for (int i = 0; i < nums.length; i++) {
            int g = nums[i];
            if(nums[i]<k )continue; //extra checks
            if (g == k)
                c++;
            for (int j = i + 1; j < nums.length; j++) {
                if (g < k)break; //extra checks
                g = gcd(g, nums[j]);

                if (g == k)
                    c++;
            }
        }
        return c;
    }
}