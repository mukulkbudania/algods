package geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class NextSmallestPalindrome {
    public static void main(String[] args){
        String a = "999";
        System.out.println(getNextPalindrome(a.toCharArray()));
    }

    private static String getNextPalindrome(char[] a) {
        int i=0;int j=a.length-1;
        boolean rightGreater = false;
        boolean all9 = true;
        while(i<j){
            if(a[i]<a[j])rightGreater = true;
            if(a[i]!='9' || a[j]!='9')all9 = false;
            a[j--] = a[i++];
        }
        if (all9){
            StringBuilder sb = new StringBuilder();
            sb.append('1');
            for(int x=0;x<a.length-1;x++)sb.append('0');
            sb.append('1');
            return sb.toString();
        }
        if(rightGreater){
            while (a[i]=='9'){
                a[i]='0';
                a[j++]=a[i--];
            }
            a[i]=(char)(a[i]+1);
            a[j]=a[i];
        }
        return new String(a);
    }
}
