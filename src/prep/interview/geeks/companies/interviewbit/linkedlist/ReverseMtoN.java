package prep.interview.geeks.companies.interviewbit.linkedlist;

/**
 * Created by mukulbudania on 8/4/17.
 */
public class ReverseMtoN {
    public ListNode reverseBetween(ListNode a, int m, int n) {
        if(m==n) return a;
        ListNode head = new ListNode(0);
        head.next=a;
        ListNode prev=head;
        ListNode curr=a;
        int count=1;
        while(curr!=null && count<m){
            prev=prev.next;
            curr=curr.next;
            count++;
        }
        ListNode lastprev=prev;
        ListNode lastcurr=curr;
        prev=null;
        while(curr!=null && count<=n){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        lastprev.next=prev;
        lastcurr.next=curr;
        return head.next;
    }
    public static void main(String[] args){
        ReverseMtoN reverseMtoN = new ReverseMtoN();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next=l2;l2.next=l3;
        ListNode n = reverseMtoN.reverseBetween(l1, 2, 3);
        while(n!=null){
            System.out.print(n.val + " ");
            n=n.next;
        }
        System.out.println();
    }
}
