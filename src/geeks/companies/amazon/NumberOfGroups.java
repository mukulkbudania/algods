package geeks.companies.amazon;

import java.util.Scanner;

/**
 * Created by mukulbudania on 7/18/17.
 * http://practice.geeksforgeeks.org/problems/number-of-groups/0
 */
public class NumberOfGroups {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(scanner.nextLine());
            int[] counter ={0,0,0};
            for(int j=0;j<n;j++){
                int x = scanner.nextInt();
                counter[x%3]++;
            }
            scanner.nextLine();
            int sum = 0;
            //Size 2
            if(counter[0]>=2)sum+=(counter[0]*(counter[0]-1))/2;
            sum+=counter[1]*counter[2];
            //Size 3
            for(int j=0;j<3;j++) if(counter[j]>=3) sum+=((counter[j]*(counter[j]-1)*(counter[j]-2))/6);
            sum+=counter[0]*counter[1]*counter[2];
            System.out.println(sum);
        }

    }
}
