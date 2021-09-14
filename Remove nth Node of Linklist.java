class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1=head,p2=head;
        while(p1!=null&&p1.next!=null){
            if(n<=0){
                p2=p2.next;
            }
            p1=p1.next;
            --n;
        }
        if(n>0){                      // The only edge case removed with this condition
            head=head.next;
        }else{
            p2.next=p2.next.next;
        }
        return head;
    }
}