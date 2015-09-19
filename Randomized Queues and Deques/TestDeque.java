import java.util.Iterator;

public class TestDeque {
    public static void main(String args[]) {
        Deque<Integer> d = new Deque<Integer>();
        for (int i = 0; i < 3; i++)
            d.addLast(i);
//        for (int j : d)
//            StdOut.println(j);
        for (int i = 0; i < 3; i++)
            d.removeLast();
        for (int i = 3; i < 5; i++)
            d.addLast(i);
//        for (int i = 0; i < 130; i++)
//            d.removeLast();
        
        //d.removeFirst();
        Iterator<Integer> i = d.iterator();
        while (i.hasNext()) {
            int s = i.next();
            StdOut.println(s);
        }
        StdOut.println(d.isEmpty());
        StdOut.println(d.size());
        for (int j = 0; j < 2; j++)
            d.removeLast();
        StdOut.println(d.isEmpty());
        StdOut.println(d.size());
        
    }
}