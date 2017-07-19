package prep.interview.geeks.companies.amazon;

import java.util.Scanner;

/**
 * Created by mukulbudania on 7/18/17.
 * http://practice.geeksforgeeks.org/problems/count-the-elements/0
 */
public class GetMaxTillElement {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(in.nextLine());
            int max = Integer.MIN_VALUE;
            int a[] = new int[n];
            for(int j=0;j<n;j++){
                a[j] = in.nextInt();
                if(a[j]>max)max=a[j];
            }
            in.nextLine();
            int counter[] = new int[max+1];
            for(int j=0;j<=max;j++)counter[i]=0;
            for(int j=0;j<n;j++){
                int x = in.nextInt();
                if(x<=max)counter[x]++;
            }
            in.nextLine();
            for(int j=1;j<=max;j++)counter[j]+=counter[j-1];
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(counter[a[j]] + ",");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}
