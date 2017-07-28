package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 7/28/17.
 * Converting from a to b
 */
public class EditDistance {
    public static void main(String[] args){
        String a = "aggtab";
        String b = "gxtxayb";
        System.out.println(editDistance(a,b));
    }

    private static int editDistance(String a, String b) {
        int l[][] = new int[b.length()+1][a.length()+1];
        int x[][] = new int[b.length()+1][a.length()+1];
        for(int i=0;i<=b.length();i++){
            l[i][0]=i;
            x[i][0]=2;
        }
        for(int i=0;i<=a.length();i++){
            l[0][i]=i;
            x[0][i]=1;
        }
        x[0][0]=0;
        for(int i=1;i<=b.length();i++){
            for(int j=1;j<=a.length();j++){
                if(b.charAt(i-1)==a.charAt(j-1)) {
                    l[i][j] = l[i-1][j-1];
                    x[i][j] = 3;
                }
                else {
                    int up = l[i-1][j];
                    int left = l[i][j-1];
                    int diagonal = l[i-1][j-1];
                    int val=1+Math.max(a.length(),b.length());
                    if (left < val) {val = left;x[i][j]=1;}
                    if (up < val) {val = up;x[i][j]=2;}
                    if (diagonal < val) {val = diagonal;x[i][j]=4;}
                    l[i][j]=1+val;
                }
            }
        }
        int i=b.length();int j=a.length();
        while(i+j>0){
            switch (x[i][j]){
                case 1: System.out.println("delete " + a.charAt(--j) + ";");break;
                case 2: System.out.println("insert " + b.charAt(--i) + ";");break;
                case 3: i--;j--;break;
                case 4: System.out.println("replace " + a.charAt(--j) + " with "+ b.charAt(--i) + ";");break;
            }
        }
        return l[b.length()][a.length()];
    }
}
