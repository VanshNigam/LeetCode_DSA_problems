class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l=1,r=Long.MAX_VALUE;
        long ans=0;
        for(int i=0;i<ranks.length;i++) r=Math.min(r,ranks[i]);
        r=r*cars*cars;
        while(l<=r){
            long mid=(l+r)/2;
            int sum=0;
            for(int j=0;j<ranks.length;j++){
                sum+=Math.sqrt(mid/ranks[j]);
            }if(sum<cars) l=mid+1;
            else{
                ans=mid;
                r=mid-1;
            }
        }return ans;
    }
}