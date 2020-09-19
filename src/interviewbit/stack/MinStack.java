package interviewbit.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mukulbudania on 8/5/17.
 */
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private int min=Integer.MAX_VALUE;
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            min=x;
            return;
        }
        if(x>=min) {
            stack.push(x);
            return;
        }
        stack.push((int)((long)2*x-min));
        min=x;
    }

    public void pop() {
        if(!stack.isEmpty()){
            int ele = stack.pop();
            if(ele<min) min = (int)((long)2*min-ele);
        }
    }

    public int top() {
        if(stack.isEmpty()) return -1;
        int ele = stack.peek();
        if(ele<min) return min;
        else return ele;
    }

    public int getMin() {
        if(stack.isEmpty()) return -1;
        return min;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        MinStack minStack = new MinStack();
        for(int i=0;i<n;i++){
            String x = in.next();
            switch (x){
                case "P": int num=in.nextInt();minStack.push(num);break;
                case "p": minStack.pop();break;
                case "t": System.out.println(minStack.top());break;
                case "g": System.out.println(minStack.getMin());break;
            }
        }
    }
}
