package prep.interview.geeks.algo.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mukulbudania on 7/13/17.
 */
public class WordWrapProblem {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<Integer> wordsLength= new ArrayList<Integer>();
        while(true){
            while (in.hasNextInt()){
                wordsLength.add(in.nextInt());
            }
            in.nextLine();
            int maxWidth = Integer.parseInt(in.nextLine());
            System.out.println(getminCostWordWrap(wordsLength,maxWidth));
        }



    }

    private static int getminCostWordWrap(List<Integer> wordsLength, int maxWidth) {
        return 0;
    }
}
