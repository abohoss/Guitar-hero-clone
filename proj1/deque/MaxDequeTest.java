package deque;

import org.junit.Test;

public class MaxDequeTest {
    @Test
    public void maxTest(){
        MaxArrayDeque.IntComparator i=new MaxArrayDeque.IntComparator();
        MaxArrayDeque<Integer> m=new MaxArrayDeque<>(i);
        m.addFirst(34);
        m.addFirst(678);
        m.addFirst(3);
        m.addFirst(-9);
        System.out.println(m.max());
        System.out.println(m.max(i));

    }
}
