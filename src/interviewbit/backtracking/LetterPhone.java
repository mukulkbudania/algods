package interviewbit.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mukulbudania on 8/4/17.
 */
public class LetterPhone {
    private static Map<Character,String> keyMap;
    static{
        keyMap = new HashMap<>();
        keyMap.put('0',"0");
        keyMap.put('1',"1");
        keyMap.put('2',"abc");
        keyMap.put('3',"def");
        keyMap.put('4',"ghi");
        keyMap.put('5',"jkl");
        keyMap.put('6',"mno");
        keyMap.put('7',"pqrs");
        keyMap.put('8',"tuv");
        keyMap.put('9',"wxyz");
    }
    public ArrayList<String> letterCombinations(String a) {
        ArrayList<String> result = new ArrayList<String>();
        keypadUtil(a,"",0,result);
        return result;
    }
    private void keypadUtil(String a,String stringTillNow,int index, List<String> result){
        if(index>=a.length()){
            result.add(stringTillNow);
            return;
        }
        String possibleChars = keyMap.get(a.charAt(index));
        if(possibleChars!=null){
            for(int i=0;i<possibleChars.length();i++){
                keypadUtil(a,stringTillNow+possibleChars.charAt(i),index+1,result);
            }
        }

    }
}
