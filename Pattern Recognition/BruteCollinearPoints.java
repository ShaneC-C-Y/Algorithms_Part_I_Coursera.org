import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.Collection;

public class BruteCollinearPoints {
//    private ArrayList<LineSegment> segments;
    private LineSegment[] segment;
    private int num = 0;
    public BruteCollinearPoints(Point[] points) {
        Point p, q, r, s;
        if (points.length < 4)
            return;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        p = points[i];
                        q = points[j];
                        r = points[k];
                        s = points[l];
                        double slope1 = p.slopeTo(q);//p q
                        double slope2 = p.slopeTo(r);//p r
                        double slope3 = p.slopeTo(s);//p s
                        if ((slope1 == slope2) & (slope1 == slope3)){
                            Point[] four = new Point[4];
                            four[0] = p;
                            four[1] = q;
                            four[2] = r;
                            four[3] = s;
                            Arrays.sort(four);
//                            segments = new LineSegment[4];
                            segment = new LineSegment[100];
                            LineSegment temp = new LineSegment(four[3], four[0]);
//                            segments.add(temp);
                            segment[num] = temp;
                            num++;
                        }
                    }
                }
            }
        }
    }// finds all line segments containing 4 points
    public           int numberOfSegments(){
        return num/3;
    }// the number of line segments
    public LineSegment[] segments() {
        return segment;
    }               // the line segments
}
