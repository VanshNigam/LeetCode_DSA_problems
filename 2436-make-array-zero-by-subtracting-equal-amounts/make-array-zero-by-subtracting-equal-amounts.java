class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i : nums) pq.add(i);
        int sub = 0,c = 0;
        while (!pq.isEmpty()) {
            int pop = pq.poll();
            if (pop - sub != 0){
                sub += (pop - sub);
                c++;
            }
        }
        return c;
    }
}