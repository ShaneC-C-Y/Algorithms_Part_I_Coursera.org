import edu.princeton.cs.algs4.StdOut;
import java.lang.String;

public class TestRandomizedQueue {
    public static void main(String[] agrs) {
        RandomizedQueue<String> r = new RandomizedQueue<String>();
        r.enqueue("A");
        r.enqueue("B");
        r.enqueue("C");
        r.enqueue("D");
        String item = r.dequeue();
        StdOut.println(item);
    }
}