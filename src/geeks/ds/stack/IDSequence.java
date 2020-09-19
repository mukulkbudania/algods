package geeks.ds.stack;

import java.util.Stack;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class IDSequence {
    public static void main(String[] args){
        String sequence = "DDIDDIID";
        Stack<Integer> s = new Stack<>();
        s.push(1);
        int counter=1;
        for(int i=0;i<sequence.length();i++){
            if(sequence.charAt(i)=='I') while (!s.isEmpty()) System.out.print(s.pop());
            s.push(++counter);
        }
        while (!s.isEmpty()) System.out.print(s.pop());
    }
}
