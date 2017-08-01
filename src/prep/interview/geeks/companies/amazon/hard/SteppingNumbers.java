package prep.interview.geeks.companies.amazon.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mukulbudania on 7/30/17.
 */
public class SteppingNumbers {
    public static void main(String[] args){
        int start = 0;int end=289;
        printSteppingNumbers(start,end);
    }

    private static void printSteppingNumbers(int start, int end) {
        for(int i=0;i<9;i++){
            doBFS(start,end,i);
        }
    }

    private static void doBFS(int start, int end, int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int num = q.poll();
            //Print numbers
            if(num>=start && num<=end){
                System.out.println(num + " ");
            }
            // make sure numbers dont start from 0 and they are not greater than end
            if(num==0 || num>end){
                continue;
            }
            int lastDigit=num%10;
            //push last digits
            if(lastDigit!=0)q.add((num)*10+lastDigit-1);
            if(lastDigit!=9)q.add((num)*10+lastDigit+1);
        }
    }
}
