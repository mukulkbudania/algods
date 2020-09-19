package prep.others.indix;

import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;

public class Calculate {
    //Enum to Store the Operation
    private enum Operation{
        NULL,BACK,UP,DOWN
    };
    //A single QueueNode for BFS Queue
    private class QueueEntry{
        private Operation operation;
        private int channelNumber;
        private int watchListIndex;
        QueueEntry(Operation op, int channelNumber, int watchListIndex){
            this.operation = op;
            this.channelNumber = channelNumber;
            this.watchListIndex = watchListIndex;
        }
        public boolean equals(QueueEntry e){
            return (this.operation==e.operation && this.channelNumber==e.channelNumber && this.watchListIndex==e.watchListIndex);
        }
    }
    /*
     * private member variables
     */
    private int start;
    private int end;
    private Set<Integer> blockedSet;
    private int[] watchList;
    //BFS Queue
    private Queue<QueueEntry> queue;
    //EMPTY NODE
    private final QueueEntry EMPTY;

    /*
     * Constructor
     * Having the blocked Channels as a HashSet gives us the advantage of lookup in O(1),
     *     as the only operation done on it is contains
     */
    public Calculate(int start, int end, Set<Integer> blockedSet, int[] watchList) {
        this.start = start;
        this.end = end;
        this.blockedSet = blockedSet;
        this.watchList = watchList;
        this.queue = new LinkedList<QueueEntry>();
        EMPTY = new QueueEntry(null,-1,-1);
    }
    /*
     * returns the number for keys to be pressed in case of going through number keys.
     */
    private int numberKeysRequired(int channel){
        int result = 0;
        while(channel>0){
            result++;
            channel = channel/10;
        }
        return result;
    }
    /*
     * returns the minimum number of clicks required to move from channel at startIndex to channel at endIndex
     * currentMin is the number of number keys required.
     * If the back, up and down keys are able to do it in less than the number of number keys use them else use the number keys.
     */
    private int minfromBFSOperations(int startChannelIndex, int endChannelIndex, int currentMin) {
        queue.clear();
        if(watchList[startChannelIndex]==watchList[endChannelIndex])return 0;
        queue.offer(new QueueEntry(Operation.NULL,watchList[startChannelIndex],startChannelIndex));
        queue.offer(EMPTY);
        int nullCount = 1;
        QueueEntry currNode;
        while(nullCount<currentMin){
            currNode = queue.poll();
            /*
             * the empty node keeps track of the number of clicks
             */
            if(currNode.equals(EMPTY)){
                nullCount++;
                queue.offer(EMPTY);
                continue;
            }
            Operation currOperation = currNode.operation;
            QueueEntry upEntry = getUpEntry(currNode.channelNumber);
            if(upEntry.channelNumber==watchList[endChannelIndex])return nullCount;
            QueueEntry downEntry = getDownEntry(currNode.channelNumber);
            if(downEntry.channelNumber==watchList[endChannelIndex])return nullCount;
            /*
             * If this is the first operation,
             * OR the last operation was back the next operation can be back,up or down,
             * But if the last operation was up then next operation can only be up,
             * And if the last operation was down the next operation can only be down
             */
            switch(currOperation){
                case NULL:
                case BACK: if(currNode.watchListIndex==0)continue;
                    QueueEntry backEntry = getBackEntry(currNode.watchListIndex);
                    if(backEntry.channelNumber==watchList[endChannelIndex])return nullCount;
                    queue.offer(backEntry);
                    queue.offer(upEntry);
                    queue.offer(downEntry);
                    break;
                case UP: queue.offer(upEntry);break;
                case DOWN: queue.offer(downEntry);break;
            }
        }
        return nullCount;
    }
    /*
     * Gets the queue entry when down button is pressed
     */
    private QueueEntry getDownEntry(int channelNumber) {
        if(channelNumber==this.start)channelNumber=this.end;
        else channelNumber--;
        while(blockedSet.contains(channelNumber)){
            if(channelNumber==this.start)channelNumber=this.end;
            else channelNumber--;
        }
        return new QueueEntry(Operation.DOWN,channelNumber,-1);
    }
    /*
     * Gets a queue entry when up button is pressed.
     */
    private QueueEntry getUpEntry(int channelNumber) {
        if(channelNumber==this.end)channelNumber=this.start;
        else channelNumber++;
        while(blockedSet.contains(channelNumber)){
            if(channelNumber==this.end)channelNumber=this.start;
            else channelNumber++;
        }
        return new QueueEntry(Operation.UP,channelNumber,-1);
    }
    /*
     * Gets a queue entry when back button is pressed
     */
    private QueueEntry getBackEntry(int watchListIndex) {
        if(watchListIndex==0) return null;
        return new QueueEntry(Operation.BACK,watchList[watchListIndex-1],watchListIndex-1);
    }
    /*
     * public method which returns the minimum number for Clicks required to browse throw the wishList of Channels
     */
    public int findMinClicks() {
        int watchListLength = watchList.length;
        if(watchListLength==0) return 0;
        int minClicks = numberKeysRequired(watchList[0]);
        for(int i=1;i<watchListLength;i++){
            int min = minfromBFSOperations(i-1,i,numberKeysRequired(watchList[i]));
            minClicks+=min;
        }
        return minClicks;
    }
}
