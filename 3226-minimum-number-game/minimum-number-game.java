class Solution {
    public int[] numberGame(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];

        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->a-b);
        for(int i:nums)pq.add(i);

        int bob,alice,i=0;
        while(!pq.isEmpty()){
            alice=pq.poll();
            bob=pq.poll();

            arr[i++]=bob;
            arr[i++]=alice;
        }
        return arr;
    }
}