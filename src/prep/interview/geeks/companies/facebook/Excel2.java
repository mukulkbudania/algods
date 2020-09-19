package prep.interview.geeks.companies.facebook;

public class Excel2 {
    public static void main(final String[] args){
        final Excel2 excel2 = new Excel2();
        for(int i=1;i<=702;i++){
            final String changed = excel2.convertToTitle(i);
            System.out.print(changed + "   ");
            final int y=excel2.convertFromTitle(changed);
            System.out.println(y);
        }
    }

    public String convertToTitle(int a) {
        final StringBuilder stringBuilder = new StringBuilder();
        while(a>0){
            final int y = a%26;
            if(y==0){ stringBuilder.append('Z'); a-=26; }else stringBuilder.append((char)('A'+y-1));
            a=a/26;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public int convertFromTitle(final String a) {
        int x = 0;
        for(int i=0;i<a.length();i++){
            x = x*26 + (a.charAt(i)-'A' + 1);
        }
        return x;
    }
}
