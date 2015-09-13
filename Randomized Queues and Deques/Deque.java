/* update on 9/13/2015 13:41   */
/* just a version match the API*/
import java.util.*;

public class Deque<Item> implements Iterable<Item> {
    private Item str;

    public Deque() {
        
    }// construct an empty deque
    public boolean isEmpty() {
        return false;
    }                 // is the deque empty?
    public int size(){
        return 0;
    }// return the number of items on the deque
    public void addFirst(Item item) {
    
    }          // add the item to the front
    public void addLast(Item item) {
    
    }          // add the item to the end
    public Item removeFirst() {
        return str;
    }               // remove and return the item from the front
    public Item removeLast() {
        return str;
    }                // remove and return the item from the end
    public Iterator<Item> iterator() {
        List<Item> dequelist = new ArrayList<Item>();
        Iterator<Item> iter = dequelist.iterator();
        return iter;
    }        // return an iterator over items in order from front to end
    public static void main(String[] args) {
    
    }  // unit testing
}