class Solution {
    public static boolean possible(int mid,int k,int []arr){
        int i=0;
        int s=0;
        int c=1;
        
        while(i<arr.length){
            if (arr[i] > mid) return false; 
            if (s + arr[i] > mid) {
                c++;
                s = 0;
            } 
            s += arr[i];
            i++;
        }
        return c<=k;
    }
    public int splitArray(int[] arr, int k) {
        if (arr.length < k) return -1; 
        int l=0;
        int r=0;
        for(int i:arr){
            l = Math.max(l, i);
            r+=i;
        }
        int ans = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (possible(mid, k, arr)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}