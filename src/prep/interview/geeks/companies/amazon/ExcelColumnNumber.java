package prep.interview.geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class ExcelColumnNumber {
    public static void main(String[] args){
        int a = 26*26*5 +26;
        System.out.println(getColumnNumber(a));
    }

    private static String getColumnNumber(int a) {
        StringBuilder sb = new StringBuilder();
        while(a>0){
            int x = a%26;
            if(x==0){
                sb.append('Z');
                a=a-1;
            } else {
                sb.append((char)('A'+(x-1)));
            }
            a=a/26;
        }
        sb.reverse();
        return sb.toString();
    }
}
