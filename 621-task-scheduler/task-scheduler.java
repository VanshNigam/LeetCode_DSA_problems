class Solution {
    public int leastInterval(char[] tasks, int n) {
        int arr[] = new int[26];
        int ans = 0;

        for (char c : tasks) {
            arr[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0)
                pq.add(arr[i]);
        }

        Queue<int[]> q = new LinkedList<>();

        while (!pq.isEmpty() || !q.isEmpty()) {
            ans++;
            if (!pq.isEmpty()) {
                int fr = pq.poll();
                fr--;
                if (fr > 0)
                    q.add(new int[] { ans + n, fr });
            }

            while (!q.isEmpty() && q.peek()[0] <= ans) {
                pq.add(q.peek()[1]);
                q.poll();
            }
        }
        return ans;
    }
}