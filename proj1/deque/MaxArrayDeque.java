package deque;

import java.util.Comparator;

public class MaxArrayDeque<Item> extends ArrayDeque<Item>{
    Comparator<Item> cmp;
    public MaxArrayDeque(Comparator<Item> c){
        cmp=c;
    }

    public Item max(){
        if(this.size()==0) {return null;}
        Item max=this.get(0);
        for(Item i : this){
            if(cmp.compare(i,max)>0){
                max=i;
            }
        }
        return max;
    }

    public Item max(Comparator<Item> c){
        if(size()==0) {return null;}
        Item max=this.get(0);
        for(Item i : this){
            if(c.compare(i,max)>0){
                max=i;
            }
        }
        return max;
    }

    public static class IntComparator implements Comparator<Integer> {
        public int compare(Integer d1, Integer d2) {
            return d1.compareTo(d2);
        }
    }

    public static class StringComparator implements Comparator<String> {
        public int compare(String d1, String d2) {
            return d1.compareTo(d2);
        }
    }

    public static class DoubleComparator implements Comparator<Double> {
        public int compare(Double d1, Double d2) {
            return d1.compareTo(d2);
        }
    }

    public static class CharComparator implements Comparator<Character> {
        public int compare(Character d1, Character d2) {
            return d1.compareTo(d2);
        }
    }

}
