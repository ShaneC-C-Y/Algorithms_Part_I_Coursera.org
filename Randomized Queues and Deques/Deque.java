/* update on 9/13/2015 13:41   */
/* just a version match the API*/
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node end;
    
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }
    
    public Deque() {
        N = 0;
        first = null;
        end = null;
        assert check();
    } // construct an empty deque
    
    public boolean isEmpty() {
        return N == 0;
    }                 // is the deque empty?
    
    public int size() {
        return N;
    } // return the number of items on the deque
    
    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException("nothing");
        Node old_first = first;
        N++;
        first = new Node();
        if (N == 1) {
            first.next = null;
            first.prev = null;
            end = first;
            end.prev = null;
            end.next = null;
        } 
        else {
            first.next = old_first;
            first.prev = null;
            first.next.prev = first;
        }
        first.item = item;
        assert check();
    }          // add the item to the front
    public void addLast(Item item) {
        if (item == null) throw new NullPointerException("nothing");
        Node old_end = end;
        end = new Node();
        N++;
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
    }          // add the item to the end
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("no element");
        Item item = first.item;
        N--;
        first = first.next;
        if (N == 0)
            return item;
        first.prev = null; //need?*****
        
        assert check();        
        return item;
    }               // remove and return the item from the front
    
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("no element");
        Item item = end.item;
        end = end.prev;
        N--;
        if (N == 0)
            return item;
        end.next = null;
        
        assert check();
        return item;
    }                // remove and return the item from the end
    
    public Iterator<Item> iterator()  { return new DequeIterator();  }
    
    private class DequeIterator implements Iterator<Item> {
        private Node current = first;
        private int flag = 0;
        public boolean hasNext() { return current != null;                     }
        public void remove()     { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }        // return an iterator over items in order from front to end
    
    private boolean check() {
        int countN = 0;
        int back_countN = 0;
        if (end.next != null)
            return false;
        if (first.prev != null)
            return false;
        if (N == 1)
            return first == end;
        for (Node x = first; x != null; x = x.next)
            countN++;
        for (Node y = end; y != null; y = y.prev)
            back_countN++;
        return (countN == N) && (back_countN == N);
    }
    
    public static void main(String[] args) {
        Deque<String> q = new Deque<String>();
        StdOut.print(q.isEmpty() + "\n");
        q.addFirst("A");
        StdOut.print(q.isEmpty() + "\n");
        
    }  // unit testing
}