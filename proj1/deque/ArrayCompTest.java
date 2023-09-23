package deque;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class ArrayCompTest {
    @Test
    public void testThreeAddThreeRemove() {
        ArrayDeque<Integer> bug = new ArrayDeque<>();
        LinkedListDeque<Integer> al = new LinkedListDeque<>();
        al.addLast(4);
        bug.addLast(4);
        al.addLast(5);
        bug.addLast(5);
        al.addLast(6);
        bug.addLast(6);
        assertEquals(bug.size(), al.size());
        assertEquals(bug.removeLast(), al.removeLast());
        assertEquals(bug.removeLast(), al.removeLast());
        assertEquals(bug.removeLast(), al.removeLast());
    }
    @Test
    public  void testing() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        ArrayDeque<Integer> b = new ArrayDeque<>();
        int N = 500000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                b.addLast(randVal);

            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size1 = b.size();

                assertEquals(size, size1);

            } else if (operationNumber == 2) {
                if (L.size() == 0) {
                    continue;
                }
                int x = L.removeFirst();
                int y = b.removeFirst();

                assertEquals(x, y);

            } else if (operationNumber == 3) {
                if (L.size() == 0)  {
                    continue;

                }
                int x = L.removeLast();
                int y = b.removeLast();

                assertEquals(x, y);

            }
        }
    }

}
