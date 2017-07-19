package prep.interview.geeks.companies.amazon;

import java.util.Scanner;

/**
 * Created by mukulbudania on 7/18/17.
 * http://practice.geeksforgeeks.org/problems/check-set-bits/0
 */
public class AllBitsSet {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(scanner.nextLine());
            while(n>0){
                int x = n&1;
                if(x==0)break;
                n=n>>1;
            }
            if(n==0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
