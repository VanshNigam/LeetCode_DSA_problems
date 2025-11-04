class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int []ans=new int[n-k+1];
        int []fr=new int[51];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]
        );

        for(int i=0;i<k;i++)fr[nums[i]]++;

        for(int i=1;i<51;i++){
            pq.add(new int[]{fr[i],i});
        }

        for(int i=k;i<=n;i++){
            int sum=0;
            int top=x;
            while(!pq.isEmpty()){
                int temp[]=pq.poll();
                top--;
                System.out.println(temp[0]);
                if( top>=0){
                    sum+=temp[0]*temp[1];
                }
            }
            ans[i-k]=sum;
            if(i==n)break;
            
            fr[nums[i]]++;
            fr[nums[i-k]]--;
            for(int i1=1;i1<51;i1++){
                pq.add(new int[]{fr[i1],i1});
            }
        }
        return ans;
    }
}