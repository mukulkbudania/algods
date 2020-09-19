package geeks.ds.heap;

import java.util.Comparator;

/**
 * Created by mukulbudania on 7/27/17.
 */
public class Heap {
    private int[] a;
    private int size;
    private int capacity;
    private Comparator<Integer> comparator;

    Heap(int capacity, Comparator<Integer> comparator){
        this.capacity = capacity;
        this.a = new int[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    public int getSize() {return size;}
    public int getCapacity() {return capacity;}
    private int getLeft(int i){return 2*i+1;}
    private int getRight(int i){return 2*i+2;}
    private int getParent(int i){return (i-1)/2;}

    public int bubbleDown(int i){
        int smallest = i;
        int left = getLeft(i);
        int right = getRight(i);
        if(left<size && comparator.compare(a[left],a[smallest])<0){
            smallest=left;
        }
        if(right<size && comparator.compare(a[right],a[smallest])<0){
            smallest=right;
        }
        if(smallest!=i){
            swap(a,smallest,i);
            return bubbleDown(smallest);
        }
        return i;
    }
    public boolean insert(int val){
        if(this.size>=capacity-1) return false;
        a[size]=val;
        bubbleUp(size);
        size++;
        return true;
    }

    private void bubbleUp(int index) {
        int parent = getParent(index);
        while(parent>=0 && comparator.compare(a[parent],a[index])>0){
            swap(a,index,parent);
            index=parent;
            parent = getParent(index);
        }
    }

    private void swap(int[] a, int index, int parent) {
        int temp = a[index];
        a[index] = a[parent];
        a[parent] = temp;
    }

    public int extractTop(){
        if(size==0) return -1;
        int result = a[0];
        if(comparator.compare(1,0)>0){
            a[0]=Integer.MAX_VALUE;
        } else {
            a[0]=Integer.MIN_VALUE;
        }
        int x = bubbleDown(0);
        size--;
        if(x<size){
            swap(a,x,size);
            bubbleUp(x);
        }
        return result;
    }
    public int getTop(){
        if(size==0) return -1;
        return a[0];
    }
}
