package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 7/27/17.
 */
public class MakeTrue {
    public static void main(String[] args){
        char[] symbols = {'T','T','F','T'};
        char[] operations = {'|','&','^'};
        System.out.println(getNumberOfTrues(symbols, operations));
    }

    private static int getNumberOfTrues(char[] symbols, char[] operations) {
        int n = symbols.length;
        int[][] tDP = new int[n][n];
        int [][] fDP = new int[n][n];
        for(int i=0;i<n;i++){
            tDP[i][i] = (symbols[i]=='T')?1:0;
            fDP[i][i] = (symbols[i]=='F')?1:0;
        }
        for(int len=2;len<=n;++len){
            for(int start=0;start<=n-len;start++){
                int end = start+len-1;
                tDP[start][end]=fDP[start][end]=0;
                for(int index=start;index<end;index++){
                    int sum = (tDP[start][index] + fDP[start][index])*(tDP[index+1][end] + fDP[index+1][end]);
                    if(operations[index]=='&'){
                        int trueSum = tDP[start][index]*tDP[index+1][end];
                        tDP[start][end]+=trueSum;
                        fDP[start][end]+=sum-trueSum;
                    } else if(operations[index]=='|'){
                        int falseSum = fDP[start][index]*fDP[index+1][end];
                        fDP[start][end]+=falseSum;
                        tDP[start][end]+=(sum)-(falseSum);
                    } else if(operations[index]=='^'){
                        tDP[start][end] += (tDP[start][index]*fDP[index+1][end])+(fDP[start][index]*tDP[index+1][end]);
                        fDP[start][end] += (tDP[start][index]*tDP[index+1][end])+(fDP[start][index]*fDP[index+1][end]);
                    }
                }
            }
        }
        System.out.println("Printing True");
        print(tDP,n);
        System.out.println("Printing False");
        print(fDP,n);
        return tDP[0][n-1];
    }
    private static int getNumberOfTrues2(char[] symbols, char[] operations) {
        int n = symbols.length;
        int[][] tDP = new int[n][n];
        int [][] fDP = new int[n][n];
        for(int i=0;i<n;i++){
            tDP[i][i] = (symbols[i]=='T')?1:0;
            fDP[i][i] = (symbols[i]=='F')?1:0;
        }
        for(int len=2;len<=n;++len){
            for(int i=0;i<=n-len;i++){
                int j = i+len-1;
                tDP[i][j]=fDP[i][j]=0;
                for(int k=i;k<j;k++){
                    int sum = (tDP[i][k] + fDP[i][k])*(tDP[k+1][j] + fDP[k+1][j]);
                    if(operations[k]=='&'){
                        int trueSum = tDP[i][k]*tDP[k+1][j];
                        tDP[i][j]+=trueSum;
                        fDP[i][j]+=sum-trueSum;
                    } else if(operations[k]=='|'){
                        int falseSum = fDP[i][k]*fDP[k+1][j];
                        fDP[i][j]+=falseSum;
                        tDP[i][j]+=(sum)-(falseSum);
                    } else if(operations[k]=='^'){
                        tDP[i][j] += (tDP[i][k]*fDP[k+1][j])+(fDP[i][k]*tDP[k+1][j]);
                        fDP[i][j] += (tDP[i][k]*tDP[k+1][j])+(fDP[i][k]*fDP[k+1][j]);
                    }
                }
            }
        }
        System.out.println("Printing True");
        print(tDP,n);
        System.out.println("Printing False");
        print(fDP,n);
        return tDP[0][n-1];
    }

    private static void print(int[][] dp, int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
