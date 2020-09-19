package prep.others.indix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));
            String testcase = in.readLine();
            while(testcase!=null){
                System.out.print("Output for " + testcase);
                //second line says start and end channels
                String[] startNEnd = in.readLine().split(" ");
                int start = Integer.parseInt(startNEnd[0]);
                int end = Integer.parseInt(startNEnd[1]);

                //third line says blockedChannels. Save in HashSet as it provides O(1) lookup
                String[] blockedChannels = in.readLine().split(" ");
                int numberOfBlockedChannels = Integer.parseInt(blockedChannels[0]);
                Set<Integer> blockedSet = new HashSet<Integer>();
                for(int i = 1;i<=numberOfBlockedChannels;i++){
                    blockedSet.add(Integer.parseInt(blockedChannels[i]));
                }

                //fourth line provides a series of channels to be watched. Should be an arrayList as the order needs to be preserved and duplicates are allowed.
                String[] watchListStr = in.readLine().split(" ");
                int numberOfWatchListChannels = Integer.parseInt(watchListStr[0]);
                int[] watchList = new int[numberOfWatchListChannels];

                for(int i = 1;i<=numberOfWatchListChannels;i++){
                    watchList[i-1] = Integer.parseInt(watchListStr[i]);
                }
                //Finding the minimum number of clicks
                int minClicks = 0;
                Calculate obj = new Calculate(start,end,blockedSet,watchList);
                minClicks = obj.findMinClicks();
                System.out.println(":   " + minClicks);

                String emptyLine = in.readLine();
                if (emptyLine==null) break;
                testcase=in.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File can't be found");
        } catch (IOException e) {
            System.out.print("Problem reading from file");
        } catch (NumberFormatException e){
            System.out.println("Couldn't conver string to number. Please check the input file");
        } catch (NullPointerException e){
            System.out.print("The input file is not per standards");
        }
    }
}

