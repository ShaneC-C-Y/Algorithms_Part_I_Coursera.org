import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Subset {
    public static void main(String[] args) {
        RandomizedQueue<String> r = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            r.enqueue(item);
        }
        int N = Integer.parseInt(args[0]);
        for (int i = 0; i < N; i++) {
            String item = r.dequeue();
            StdOut.println(item);
        }
    }
}