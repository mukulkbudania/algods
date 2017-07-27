package prep.interview.geeks.algo.backtracking;

/**
 * Created by mukulbudania on 7/27/17.
 */
public class PermutationWithSpaces {
    public static void main(String[] args){
        String arr = "ABCD";
        printPermutations(arr);
    }

    private static void printPermutations(String arr) {
        if(arr.length()==0) return;
        int blen = arr.length()*2-1;
        char[] b = new char[blen];
        for(int i=0;i<blen;i++)b[i]=' ';
        b[0]=arr.charAt(0);
        printPermutations(arr.toCharArray(),b,1,1);
    }

    private static void printPermutations(char[] arr, char[] newArr, int arrIndex, int newArrIndex) {
        if(arrIndex>=arr.length){
            print(newArr,newArrIndex);
        } else {
            newArr[newArrIndex]=arr[arrIndex];
            printPermutations(arr, newArr,arrIndex + 1,newArrIndex+1);
            newArr[newArrIndex]=' ';
            newArr[newArrIndex+1]=arr[arrIndex];
            printPermutations(arr, newArr,arrIndex + 1,newArrIndex+2);
        }
    }

    private static void print(char[] newArr, int newArrIndex) {
        for(int i=0;i<newArrIndex;i++){
            System.out.print(newArr[i]);
        }
        System.out.println();
    }
}
