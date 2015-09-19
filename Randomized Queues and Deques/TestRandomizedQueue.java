import edu.princeton.cs.algs4.StdOut;
import java.lang.String;

public class TestRandomizedQueue {
    public static void main(String[] agrs) {
        RandomizedQueue<String> r = new RandomizedQueue<String>();
        r.enqueue("A");
        r.enqueue("B");
        r.enqueue("C");
        r.enqueue("D");
        String item = r.sample();
        String item_pop = r.dequeue();
        StdOut.println("sample: " + item);
        StdOut.println("dequeue: " + item_pop);
        for (String s : r)
            StdOut.println(s);
        r.dequeue();
        r.dequeue();
        r.dequeue();
        StdOut.println(r.isEmpty());
    }
}