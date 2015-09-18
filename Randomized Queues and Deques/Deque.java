/* update on 9/13/2015 13:41   */
/* just a version match the API*/
import java.util.*;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    //private Node end;
    
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }
    
    public Deque() {
        N = 0;
        first = null;
        //end = null;
        assert check();
    }// construct an empty deque
    
    public boolean isEmpty() {
        return N == 0;
    }                 // is the deque empty?
    
    public int size(){
        return N;
    }// return the number of items on the deque
    
    public void addFirst(Item item) {
        Node old_first = first;
        first = new Node();
        if (N == 0) {
            first.next = first;
            first.prev = first;
        }
        else {
            first.next = old_first;
            first.prev = old_first.prev;
            first.next.prev = first;
            first.prev.next = first;
        }
        first.item = item;
        N++;
        assert check();
    }          // add the item to the front
    public void addLast(Item item) {
        Node old_end = first.prev;
        first.prev = new Node();
        if (N == 0) {
            first.next = first;
            first.prev = first;
        }
        else {
            first.prev.next = first;
            first.prev.prev = old_end;
            old_end.next = first.prev;
        }
        first.prev.item = item;
        N++;
        assert check();
    }          // add the item to the end
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("no element");
        Item item = first.item;
        first.prev = first.next;
        first.next = first.prev;
        first = first.next;
        N--;
        assert check();        
        return item;
    }               // remove and return the item from the front
    
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("no element");
        Item item = first.prev.item;
        first.prev.next = first;
        first.prev = first.prev.prev;
        N--;
        assert check();
        return item;
    }                // remove and return the item from the end
    
    public Iterator<Item> iterator()  { return new DequeIterator();  }
    
    private class DequeIterator implements Iterator<Item> {
        private Node current = first;
        private int flag = 0;
        public boolean hasNext() {
            return current.next != first;         
        }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
//            List<Item> dequelist = new ArrayList<Item>();
//            Iterator<Item> iter = dequelist.iterator();
            return item;
        }
    }        // return an iterator over items in order from front to end
    
    private boolean check() {
        int countN = 0;
        if (first.prev.next != first)
            return false;
        for (Node x = first; x != first.prev; x = x.next)
            countN++;
        return countN++ == N;
    }
    
    public static void main(String[] args) {
        Deque<String> q = new Deque<String>();
        StdOut.print(q.isEmpty() + "\n");
        q.addFirst("A");
        StdOut.print(q.isEmpty() + "\n");
        
    }  // unit testing
}