class Solution {
    public int getDecimalValue(ListNode head) {
        String str = "";
        int ans = 0;
        while (head != null) {
            str += head.val;
            head = head.next;
        }
        System.out.println(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(str.length() - i - 1) == '1')
                ans += Math.pow(2, i);
        }
        return ans;
    }
}