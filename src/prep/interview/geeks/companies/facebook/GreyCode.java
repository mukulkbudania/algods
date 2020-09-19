package prep.interview.geeks.companies.facebook;

import java.util.ArrayList;
import java.util.Collections;

public class GreyCode {
    public static void main(String[] args){
        ArrayList<Integer> integers = new GreyCode().grayCode(3);
        integers.stream().forEach(x-> System.out.println(x));
    }

    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result = new ArrayList<>(1 << (a + 1));
        if (a == 0)
            return result;
        result.add(0);
        result.add(1);
        if (a == 1)
            return result;
        for (int i = 2; i <=a; i++) {
            ArrayList<Integer> reverseList = new ArrayList<>(result);
            Collections.reverse(reverseList);
            for(int j=0;j<reverseList.size();j++){
                reverseList.set(j,reverseList.get(j)+(1<<(i-1)));
            }
            result.addAll(reverseList);
        }
        return result;
    }
}
