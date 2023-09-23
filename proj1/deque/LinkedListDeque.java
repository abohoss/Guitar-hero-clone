package deque;

import java.util.Iterator;

public class LinkedListDeque<Item> implements Iterable<Item>,Deque<Item> {

    private class IntNode{
        private Item item;
        private IntNode next;
        private IntNode prev;

        public IntNode(Item i,IntNode n,IntNode p){
            item=i;
            next=n;
            prev=p;
        }
    }
    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    public LinkedListDeque(){
        size=0;
        sentinel=new IntNode(null,null,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
    }
    public LinkedListDeque(Item x){
        size=1;
        sentinel=new IntNode(null,null,null);
        sentinel.next=new IntNode(x,sentinel,sentinel);
        sentinel.prev=sentinel;
    }
    @Override
    public void addFirst(Item x){
        size++;
        if(size==0) {
            sentinel.next=new IntNode(x,sentinel,sentinel);
            sentinel.prev=sentinel.next;
        }
        else{
            sentinel.next = new IntNode(x, sentinel.next, sentinel);
            sentinel.next.next.prev=sentinel.next;
        }
    }
    @Override
    public void addLast(Item x){
        size++;
        if(size==0){
            sentinel.next=new IntNode(x,sentinel,sentinel);
            sentinel.prev=sentinel.next;
        }
        else{
            sentinel.prev=new IntNode(x,sentinel,sentinel.prev);
            sentinel.prev.prev.next=sentinel.prev;

        }
    }
    @Override
    public int size()   {return size;}

    public void printDeque(){
       if(sentinel.next!=sentinel){
           IntNode p=sentinel.next;
           System.out.print("Items: ");
           while(p != sentinel){
               System.out.print(p.item+" ");
               p=p.next;
           }
           System.out.println(" ");
       }
       else{
           System.out.println("list is empty!!!");
       }
    }
    @Override
    public Item removeFirst(){
        Item x=sentinel.next.item;
        if(x==null){
            return null;
        }
        size--;
        sentinel.next=sentinel.next.next;
        sentinel.next.prev=sentinel;
        return x;
    }
    @Override
    public Item removeLast(){
        Item y=sentinel.prev.item;
        if(y==null){
            return null;
        }
        size--;
        sentinel.prev=sentinel.prev.prev;
        sentinel.prev.next=sentinel;
        return y;
    }
    @Override
    public Item get(int index){
        if(index >= size){
            return null;
        }
        IntNode p=sentinel;
        for(int i=0;i<=index;i++){
            p=p.next;
        }
        return p.item;
    }

    public Item getRecursive(int index){
        if(index >= size){
            return null;
        }
        IntNode p=sentinel.next;
        return getRecursive(index,p);
    }

    private Item getRecursive(int index, IntNode p) {
        if(index == 0){
            return p.item;
        }
        return getRecursive(index-1,p.next);
    }

    @Override
    public boolean equals(Object o){
        if(this == o)   {return true;}
        if(o instanceof LinkedListDeque ){
            LinkedListDeque li=(LinkedListDeque) o;
            // return false if both are not same size,
            if(this.size != li.size)    {return false;}
            for(Item i : this){
                if(!li.contains(i))   {return false;}
            }
            return true;
        }
        return false;
    }

    /*Iterates over list to see if element is in the list. */
    private boolean contains(Item x){
        for(Item i : this){
            if(i.equals(x)) {return true;}
        }
        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedLIstIterator();
    }

    private class LinkedLIstIterator implements Iterator<Item>{
        private int wizPos;
        public LinkedLIstIterator(){
            wizPos=0;
        }
        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public Item next() {
            Item returnItem = get(wizPos);
            wizPos++;
            return returnItem;
        }
    }

}
