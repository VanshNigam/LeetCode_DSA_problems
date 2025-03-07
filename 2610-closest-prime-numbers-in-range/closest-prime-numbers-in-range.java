class Solution {
    public int[] closestPrimes(int left, int right) {

        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int arr[] = new int[right + 1];
        arr[1] = 1;

        if (right <= 2)
            return ans;

        for (int i = 2; i < Math.sqrt(right) + 1; i++) {
            if (arr[i] == 0)
                for (int j = i * i; j <= right; j += i) {
                    arr[j] = 1;
                }
        }

        int gap = right - left;
        int prev = -1;

        int f = -1;
        int l = -1;

        for (int i = left; i <= right; i++) {
            if (arr[i] == 0) {
                if (prev == -1) {
                    f = i;
                } else if (l == -1) {
                    l = i;
                    gap = Math.min(l - f, gap);
                } else {
                    if ((i - prev) < gap) {
                        l = i;
                        f = prev;
                        gap = l - f;
                    }
                }
                prev = i;
                // System.out.println(i+" "+f+" "+l+" -- "+gap);
            }
        }
        if (f == -1 || l == -1)
            return new int[] { -1, -1 };
        ans[0] = f;
        ans[1] = l;
        return ans;
    }
}