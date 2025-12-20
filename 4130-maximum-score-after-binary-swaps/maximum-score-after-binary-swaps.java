class Solution {
    public long maximumScore(int[] nums, String s) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);

        // for(int i:nums)

        long ans=0;
        int i=0;
        for(char c:s.toCharArray()){
            pq.add(nums[i]);i++;
            if(c=='1')ans+=pq.poll();
        }
        return ans;
    }
}