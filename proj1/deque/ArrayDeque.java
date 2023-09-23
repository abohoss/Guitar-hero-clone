package deque;

import java.util.Iterator;

public class ArrayDeque<Item> implements Iterable<Item>, Deque<Item>{
    private int size;
    private Item items[];
    protected int nextFirst;
    protected int nextLast;
    public ArrayDeque(){
        items=(Item[]) new Object[8];
        size=0;
        nextFirst=2;
        nextLast=3;
    }
    @Override
    public void addFirst(Item x){
        if(size == items.length){
            resize(size*2);
        }
        if(nextFirst<0){
            nextFirst = items.length-1;
        }
        items[nextFirst]=x;
        nextFirst--;
        size++;
    }
    @Override
    public void addLast(Item x){
        if(size == items.length){
            resize(size*2);
        }
        if(nextLast == items.length){
            nextLast=0;
        }
        items[nextLast]=x;
        nextLast++;
        size++;
    }

    private void resize(int cap) {
        Item[] a=(Item[]) new Object[cap];
        //difference between index 0 and inner array start value
        int diff = nextFirst+1;
        int count=0;
        for(int i=diff;i<items.length;i++){
            if(items[i]==null)  {continue;}
            a[i-diff]=items[i];
            count++;
        }
        //
        for(int j=0;j<=nextFirst;j++){
            if(items[j]==null)  {break;}
            a[count+j]=items[j];
        }
        nextFirst = cap-1;
        nextLast = size;
        items = a;
    }
    @Override
    public int size()   {return size;}
    @Override
    public Item get(int index){
        int count=0;
        Item returnItem=items[0];
        for(Item i : this){
            if(count == index){
                returnItem=i;
                break;
            }
            count++;
        }
        return returnItem;
    }
    @Override
    public void printDeque(){
        System.out.print("Items: ");
        for(Item i : this){
            System.out.print(i+" ");
        }
        System.out.println(" ");
    }
    @Override
    public Item removeFirst(){
        if(size>16){
            double R=(double)size/ items.length;
            if(R<0.25){
                resize(items.length/2);
            }
        }
        if(nextFirst== items.length-1)  {nextFirst = -1;}
        Item x=items[nextFirst+1];
        if(x==null) {return null;}
        items[nextFirst+1] = null;
        nextFirst++;
        size--;
        return x;
    }
    @Override
    public Item removeLast(){
        if(size>16){
            double R=(double)size/ items.length;
            if(R<0.25){
                resize(items.length/2);
            }
        }
        if(nextLast==0){
            nextLast= items.length;
        }
        Item x=items[nextLast-1];
        if(x==null) {return null;}
        items[nextLast-1] = null;
        nextLast--;
        size--;
        return x;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)   {return true;}
        if(o instanceof ArrayDeque){
            ArrayDeque li=(ArrayDeque) o;
            // return false if both are not same size,
            if(this.size != li.size)    {return false;}
            for(Item i : this){
                if(i==null) {continue;}
                if(!li.contains(i))   {return false;}
            }
            return true;
        }
        return false;
    }

    /*Iterates over array to see if element is in the list. */
    private boolean contains(Item x) {
        for(Item i : this){
            if(i==null) {
                continue;
            }
            if(i.equals(x)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<Item>{
        private int wizPos;
        private int count;
        public ArrayDequeIterator() {
            wizPos = nextFirst+1;
            count=0;
        }
        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public Item next() {
            if(wizPos== items.length)  {wizPos = 0;}
            Item returnItem = items[wizPos];
            while(returnItem == null){
                wizPos++;
                if(wizPos== items.length)  {wizPos = 0;}
                returnItem = get(wizPos);
            }
            wizPos++;
            count++;
            return returnItem;
        }
    }



}
