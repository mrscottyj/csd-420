import java.util.Iterator;
import java.util.LinkedList;
 
public class JohnsonModule4_2 {
 
    public static void main(String[] args) {
        int[] sizes = {50000, 500000};
 
        for (int size : sizes) {
            // fill the list with the numbers 0 up to size - 1
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                list.add(i);
            }
 
            // traverse with an iterator and add up the values
            long start = System.currentTimeMillis();
            long iteratorSum = 0;
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                iteratorSum += it.next();
            }
            long iteratorTime = System.currentTimeMillis() - start;
 
            // traverse with get(index) and add up the values
            start = System.currentTimeMillis();
            long getSum = 0;
            for (int i = 0; i < list.size(); i++) {
                getSum += list.get(i);
            }
            long getTime = System.currentTimeMillis() - start;
 
            System.out.println("Size: " + size);
            System.out.println("Iterator time: " + iteratorTime + " ms");
            System.out.println("get(index) time: " + getTime + " ms");
 
            // test code: both sums should match the formula n(n-1)/2
            long expected = (long) size * (size - 1) / 2;
            if (iteratorSum == expected && getSum == expected) {
                System.out.println("Test passed, both sums are " + expected);
            } else {
                System.out.println("Test failed");
            }
            System.out.println();
        }
    }
}

/*
Results and explanation:

With 50,000 integers the iterator took 8 ms and the get(index) loop took
1282 ms. With 500,000 integers the iterator took 12 ms and the get(index)
loop took 181966 ms, which is about 3 minutes. Both tests passed, so
both ways of looping added up every number correctly.

The iterator stayed fast because it remembers where it is in the list.
Each step just moves from one node to the next, so the total work grows
in a straight line with the size of the list (O(n)). The list got 10
times bigger and the time stayed tiny. These times are so small that the
measurement is not exact, so the jump from 8 ms to 12 ms is not
meaningful.

The get(index) loop got much slower because a LinkedList cannot jump to
a spot. Every call to get(i) starts at the front or the back and moves
node by node until it reaches index i. Doing that for every index adds
up to about n * n / 2 steps (O(n squared)). The list got 10 times
bigger, so the work should grow about 100 times. It actually grew about
142 times, going from 1282 ms to 181966 ms. The extra slowdown is likely
because a bigger list does not fit in the computer's fast memory as well,
so each step takes a little longer.

At 50,000 the iterator was about 160 times faster than get(index). At
500,000 it was about 15,000 times faster. The gap grows as the list
grows, so for a LinkedList the iterator (or a foreach loop) should be
used and get(index) in a loop should be avoided. get(index) is fine for
an ArrayList because it can go straight to any index.
*/