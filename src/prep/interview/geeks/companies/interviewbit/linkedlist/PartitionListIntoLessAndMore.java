package prep.interview.geeks.companies.interviewbit.linkedlist;

/**
 * Created by mukulbudania on 8/4/17.
 */
public class PartitionListIntoLessAndMore {

    public ListNode partition(ListNode a, int b) {
        ListNode head= new ListNode(0);
        head.next=a;
        ListNode prev=head;
        ListNode high=head;
        ListNode curr=a;
        while(curr!=null){
            if(curr.val<b){
                if(curr!=high.next){
                    ListNode t=curr.next;
                    curr.next=high.next;
                    high.next=curr;
                    prev.next=t;
                    curr=t;
                } else {
                    prev=prev.next;
                    curr=curr.next;
                }
                high=high.next;
            } else {
                prev=prev.next;
                curr=curr.next;
            }
        }
        return head.next;
    }
}
