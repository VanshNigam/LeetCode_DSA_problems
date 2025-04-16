/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();

        for(ListNode n:lists){
            while(n!=null){
                pq.add(n.val);
                n=n.next;
            }
        }
        ListNode ans=new ListNode('0');
        ListNode x=ans;

        while(!pq.isEmpty()){
            int a=pq.poll();
            ListNode temp=new ListNode(a);

            ans.next=temp;
            ans=ans.next;
        }

        return x.next;
    }
}