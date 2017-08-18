package prep.interview.geeks;

/**
 * Created by mukulbudania on 8/9/17.
 */
public class HorsesSolution {
    static int[][] horses_count;
    public static void main(String[] args){
        String a = "WWWBWB";
        horses_count = new int[a.length()][a.length()];
        /*for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

            }
        }*/
        int k=2;
        System.out.println(getMax(a.toCharArray(), 0, 3));
    }

    private static int getMax(char[] chars, int start, int k) {
        int end = chars.length-k;
        if(start>end) return 0;
        if(k==1) return getDiff(chars,start,chars.length);
        int max = 0;
        for(int i=start+1;i<=end;i++){
            max = Math.max(max,getDiff(chars,start,i) + getMax(chars,i,k-1));
        }
        return max;
    }

    private static int getDiff(char[] chars, int start, int end) {
        int w=0;int b=0;
        for(int j=start;j<end;j++){
            if(chars[j]=='W')w++;
            if(chars[j]=='B')b++;
        }
        return w*b;
    }
}
