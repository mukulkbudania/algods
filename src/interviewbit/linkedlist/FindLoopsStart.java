package interviewbit.linkedlist;

/**
 * Created by mukulbudania on 8/4/17.
 */
public class FindLoopsStart {

    public ListNode detectCycle(ListNode a) {
        if(a==null) return null;
        ListNode slow=a;
        ListNode fast=a.next;
        while(fast!=null && slow!=fast ){
            slow = slow.next;
            fast = fast.next;
            if(fast!=null)fast=fast.next;
        }
        if(fast==null)return null;
        int counter=1;slow=slow.next;
        while(slow!=fast){
            counter++;slow=slow.next;
        }
        slow=a;fast=a;
        while(counter>0){
            fast=fast.next;
            counter--;
        }
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
