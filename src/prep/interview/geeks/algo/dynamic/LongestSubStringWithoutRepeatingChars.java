package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 8/17/17.
 * f(n)=f(n-1)*(n-1)f(n-2)
 */
public class LongestSubStringWithoutRepeatingChars {
    public static void main(String[] args){
        System.out.println(getMax("geeksforgeeks".toCharArray()));
    }

    private static int getMax(char[] a) {
        int visited[] = new int[26];
        for(int i=0;i<26;i++) visited[i]=-1;
        int maxSize=0;int size=0;int start=0;
        for(int i=0;i<a.length;i++){
            int x=visited[a[i]-'a'];
            if(x==-1){
                size++; maxSize = Math.max(size,maxSize);
            } else {
                for(int j=start;j<=x;j++){
                    size--;visited[a[j]-'a']=-1;
                }
                start=x+1;size+=1;
            }
            visited[a[i]-'a']=i;
        }
        return maxSize;
    }
}
