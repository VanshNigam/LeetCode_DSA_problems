class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        int sum=0;
        for(int i:nums)sum=(sum+i%p)%p;
        
        int rem=sum%p;
        if(rem==0)return 0;

        Map<Integer,Integer>mp=new HashMap<>();
        mp.put(0,-1);
 
        int curr=0;
        int min=n;
        for(int i=0;i<n;i++){
            curr=(curr+nums[i])%p;
            int key = (curr- rem + p) % p;

            if(mp.containsKey(key))min=Math.min(i-mp.get(key),min);
            mp.put(curr,i);
        }
        return min==n?-1:min;
    }
}