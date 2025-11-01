/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode res1 = res;

        HashSet<Integer> set = new HashSet<>();

        // Add elements from the nums array to the set
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        while (head != null) {
            if (!set.contains(head.val)) {
                ListNode temp = new ListNode(head.val);
                res.next = temp;
                res = res.next;
            }
            head = head.next;
        }
        res.next = null;
        return res1.next;
    }
}