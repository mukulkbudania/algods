package interviewbit.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by mukulbudania on 8/5/17.
 */
public class NextSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        int n = arr.size();
        ArrayList<Integer> result = new ArrayList<Integer>(n);

        Stack<Integer> stack = new Stack<Integer>();
        for(int i=n-1;i>=0;i--){
            if(!stack.isEmpty() && arr.get(i)<arr.get(stack.peek())){
                int x = stack.pop();
                result.set(x,arr.get(i));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            result.set(stack.pop(),-1);
        }
        return result;
    }
}
