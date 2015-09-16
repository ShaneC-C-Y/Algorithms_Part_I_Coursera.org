/* update on 9/13/2015 13:41   */
/* just a version match the API*/
import java.util.*;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node end;
    
    private class Node {
        private Item item;
        private Node next;
    }
    
    public Deque() {
        N = 0;
        first = null;
        end = null;
        assert check();
    }// construct an empty deque
    
    public boolean isEmpty() {
        return N == 0;
    }                 // is the deque empty?
    
    public int size(){
        return N;
    }// return the number of items on the deque
    
    public void addFirst(Item item) {
        Node temp = first;  // Item temp = first.item (X
        first = new Node();
        first.item = item;
        first.next = temp;
        N++;
        if (N == 1)
            end = first;
        assert check();
    }          // add the item to the front
    public void addLast(Item item) {
        Node temp = end;
        end = new Node();
        temp.next = end;
        end.item = item;
        N++;
        if (N == 1)
            first = end;
        assert check();
    }          // add the item to the end
    public Item removeFirst() {
        Item item = first.item;
        first = first.next;
        return item;
    }               // remove and return the item from the front
    public Item removeLast() {
        return end.item;
    }                // remove and return the item from the end
    public Iterator<Item> iterator() {
        List<Item> dequelist = new ArrayList<Item>();
        Iterator<Item> iter = dequelist.iterator();
        return iter;
    }        // return an iterator over items in order from front to end
    private boolean check() {
        int countN = 0;
        for (Node x = first; x != end; x = x.next)
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