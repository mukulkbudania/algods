package interviewbit.linkedlist;

/**
 * Created by mukulbudania on 8/4/17.
 */
public class ReverseEveryKNodes {
    public ListNode reverseList(ListNode A, int B) {
        ListNode lastprev=null;
        ListNode lastcurr=A;
        ListNode curr=A;
        while(curr!=null){
            ListNode prev=null;
            int k=B;
            while(k>0 && curr!=null){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                k--;
            }
            if(lastprev==null){
                A=prev;
            } else {
                lastprev.next=prev;
            }
            lastprev=lastcurr;
            lastcurr=curr;
        }
        return A;
    }
}
