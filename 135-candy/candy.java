class Solution {
    public int candy(int[] nums) {
        int c = 1;
        int n = nums.length;
        int m1 = 0;
        int m2 = 0;

        int ans[]=new int[n];
        ans[0]=1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                c++;
                ans[i]=c;
            } else {
                c = 1;
                ans[i]=c;
            }
        }
        c = 1;
        ans[n-1]=Math.max(ans[n-1],1);

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                c++;
                ans[i]=Math.max(ans[i],c);
            } else {
                c = 1;
                ans[i]=Math.max(ans[i],c);
            }
        }
        int x=0;

        for(int y:ans)x+=y;

        return x;
    }
}