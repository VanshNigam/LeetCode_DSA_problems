class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap for ListNodes (compare by value)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add only the first node of each list
        for (ListNode n : lists) {
            if (n != null) pq.add(n);
        }

        ListNode ans = new ListNode(0); // dummy node
        ListNode tail = ans;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll(); // O(log k)
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                pq.add(smallest.next); // O(log k)
            }
        }

        return ans.next;
    }
}
  