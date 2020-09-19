package geeks.companies.amazon.hard;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class SmallestAllCharWindow {
    public static void main(String[] args){
        String a = "aabcbcdbca";
        System.out.println(minimumWindow(a.toCharArray()));
    }

    private static int minimumWindow(char[] arr) {
        int n = arr.length;
        //Find number of distinct.
        int totalDistinctCount=0;
        int freq[] = new int[26];
        for(int i=0;i<26;i++)freq[i]=0;
        for(int i=0;i<n;i++){
            int countOfarrI = arr[i]-'a';
            if(freq[countOfarrI]==0) totalDistinctCount++;
            freq[countOfarrI]++;
        }
        //iterate till we find the first window.
        for(int i=0;i<26;i++)freq[i]=0;
        int distinctCount=0;
        int i=0;
        for(;i<n;i++){
            int countOfarrI = arr[i]-'a';
            if(freq[countOfarrI]==0) distinctCount++;
            freq[countOfarrI]++;
            if(distinctCount==totalDistinctCount)break;
        }
        int start=0;int end=i+1;int minWindow=end-start;
        //Keep updating the window.
        while (end<n){
            //Move end till first and last element are same.
            while (end<n && arr[end]!=arr[start]){
                freq[arr[end]-'a']++;
                end++;
            }
            //move start till start element is present more than once.
            if(end!=n)freq[arr[end]-'a']++;
            while (freq[arr[start]-'a']!=1){
                freq[arr[start]-'a']--;
                minWindow = Math.min(minWindow,end-start);
                start++;
            }
        }
        return minWindow;
    }
}
