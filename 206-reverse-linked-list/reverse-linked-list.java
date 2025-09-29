class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode x,y,z;
        if((head==null)||(head.next==null))return head;

        x=null; y=head; z=head.next;

        while(z!=null){
            y.next=x;
            x=y;
            y=z;
            z=y.next;
        }
        y.next=x;
        return y;
    }
}