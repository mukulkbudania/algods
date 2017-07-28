package prep.interview.geeks.ds.stack;

import java.util.Stack;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class MaxAreaRectangleInHistogram {
    public static void main(String[] args){
        int[] a = {6,2,5,4,5,1,6};
        System.out.println(getMaxArea(a));
    }
    private static int getMaxArea(int[] a){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i=0;
        for(;i<a.length;i++){
            while(!stack.isEmpty() && a[i]<a[stack.peek()]){
                int height = a[stack.pop()];
                int width = stack.isEmpty()?i:i-stack.peek()-1;
                maxArea=Math.max(width*height,maxArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int height = a[stack.pop()];
            int width = stack.isEmpty()?i:i-stack.peek()-1;
            maxArea=Math.max(width*height,maxArea);
        }
        return maxArea;
    }
}
