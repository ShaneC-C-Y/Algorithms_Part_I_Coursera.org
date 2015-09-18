import java.util.Iterator;

public class TestDeque {
    public static void main(String args[]) {
        Deque<Integer> d = new Deque<Integer>();
        for (int i = 0; i < 3; i++)
            d.addFirst(i);
//        for (int j : d)
//            StdOut.println(j);
        Iterator<Integer> i = d.iterator();
        while (i.hasNext()) {
            int s = i.next();
            StdOut.println(s);
        }
    }
}