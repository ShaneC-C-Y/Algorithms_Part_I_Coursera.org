import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node end;
    
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }
    
    public RandomizedQueue() {
        first = null;
        end = null;
        N = 0;
        assert check();
    }                 // construct an empty randomized queue
    
    public boolean isEmpty() { return N == 0; }                // is the queue empty?
    public int size() { return N; }                       // return the number of items on the queue
    public void enqueue(Item item) {
        N++;
        Node old_end = end;
        end = new Node();
        if (N == 1) {
            end.prev = null;
            end.next = null;
            first = end;
            first.next = null;
            first.prev = null;
        }
        else {
            end.prev = old_end;
            end.next = null;
            end.prev.next = end;
        }
        end.item = item;
        assert check();
    }          // add the item
    
    public Item dequeue() { // semms not convenient using iterator
        int pop_num = StdRandom.uniform(N); // 0~N-1
        Node current = first;
        Item item = null;
        for (int i = 0; i < pop_num; i++)
            current = current.next;
        item = current.item;
        return item;
    }                    // remove and return a random item
    
    public Item sample() { 
        int sample_num = StdRandom.uniform(N) + 1; // 1~N
        Iterator<Item> i = this.iterator();
        Item item = null;
        for (int n = 0; n < sample_num; n++)
            item = i.next();
        return item;
    }                     // return (but do not remove) a random item
    public Iterator<Item> iterator() { return new RadomizedQueueIterator(); }
        
    private class RadomizedQueueIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() { return current != null;                     }
        public void remove()     { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item; 
        }
    }        // return an independent iterator over items in random order
    private boolean check() {
        int countN = 0;
        int back_countN = 0;
        if (end.next != null)
            return false;
        if (first.prev != null)
            return false;
        for (Node x = first; x != null; x = x.next)
            countN++;
        for (Node y = end; y != null; y = y.prev)
            back_countN++;
        return (countN == N) && (back_countN == N);
    }
    public static void main(String[] args) {
    }   // unit testing
}