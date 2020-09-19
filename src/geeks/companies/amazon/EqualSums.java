package geeks.companies.amazon;

import java.util.*;

/**
 * Created by mukulbudania on 7/18/17.
 *
 */
public class EqualSums {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(scanner.nextLine());
            List<Integer> numbers = new ArrayList<Integer>(n);
            for(int j=0;j<n;j++){
                numbers.add(scanner.nextInt());
            }
            scanner.nextLine();
            System.out.println(getEqualSums(numbers,n));
        }
    }
    private static int getEqualSums(List<Integer> a,int n){
        if(n<4)return 0;
        Set<Integer> sums = new HashSet<Integer>();
        for(int j=0;j<n-1;j++){
            for(int k=j+1;k<n;k++){
                int p=a.get(j)+a.get(k);
                if(sums.contains(p)) return 1;
                sums.add(p);
            }
        }
        return 0;
    }
}
