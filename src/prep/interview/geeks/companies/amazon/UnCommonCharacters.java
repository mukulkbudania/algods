package prep.interview.geeks.companies.amazon;

import java.util.Scanner;

/**
 * Created by mukulbudania on 7/18/17.
 */
public class UnCommonCharacters {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i=0;i<t;i++){
            String a = in.nextLine();
            boolean[] aBoolean = getHash(a);
            String b = in.nextLine();
            boolean[] bBoolean = getHash(b);
            System.out.println(getUncommonChars(aBoolean, bBoolean));
        }
    }

    private static String getUncommonChars(boolean[] aBoolean, boolean[] bBoolean) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            if((aBoolean[i] ^ bBoolean[i])){
               sb.append((char)(i+'a'));
            }
        }
        return sb.toString();
    }

    private static boolean[] getHash(String string) {
        boolean[] result = new boolean[26];
        for(char a: string.toCharArray()){
            result[a-'a']=true;
        }
        return result;
    }
}
