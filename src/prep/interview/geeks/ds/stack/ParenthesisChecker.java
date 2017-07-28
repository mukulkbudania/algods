package prep.interview.geeks.ds.stack;

import java.util.Stack;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class ParenthesisChecker {
    public static void main(String[] args){
        String parenthesis = "{}[({}[])";
        System.out.println(checkParenthesis(parenthesis));
    }

    private static boolean checkParenthesis(String parenthesis) {
        Stack<Character> chars = new Stack<>();
        for(int i=0;i<parenthesis.length();i++){
            char a = parenthesis.charAt(i);
            switch (a){
                case '(' : chars.push(a);break;
                case '{' : chars.push(a);break;
                case '[' : chars.push(a);break;
                case ']' : if(chars.isEmpty() || chars.peek()!='[')return false;
                            else {chars.pop();break;}
                case '}' : if(chars.isEmpty() || chars.peek()!='{')return false;
                            else {chars.pop();break;}
                case ')' : if(chars.isEmpty() || chars.peek()!='(')return false;
                            else {chars.pop();break;}
            }
        }
        return chars.isEmpty();
    }
}
