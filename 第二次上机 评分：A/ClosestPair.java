import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class ClosestPair {
    static Point[] point;
    static Point[] minP = new Point[2];
    //static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = 100;
        point = new Point[n];
        for (int i = 0; i < n; i++) {
            int a = (int)(Math.random()*100);
            int b = (int)(Math.random()*100);
            point[i] = new Point(a, b);
        }
//        point[0] = new Point(1,3);
//        point[1] = new Point(2,1);
//        point[2] = new Point(3,5);
//        point[3] = new Point(4,4);
//        point[4] = new Point(5,2);
        Arrays.sort(point,0, n, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return (int) (o1.x - o2.x);
            }
        });
        System.out.println(point.length);
        double minD = closestPoint(0, point.length-1);
        for (int i = 0; i < 2; i++) {
            System.out.println(minP[i].x + "," + minP[i].y);
        }
        System.out.println(minD);
    }

    private static double closestPoint(int low, int high) {
        Point[] temp1 = new Point[2];
        Point[] temp2 = new Point[2];
        Point[] p = new Point[high - low + 1];
        double d, d1, d2, d3;
        int index = 0;
        if (high - low == 1) {
            minP[0] = new Point(point[low].x, point[low].y);
            minP[1] = new Point(point[high].x, point[high].y);
            return distance(point[low], point[high]);
        }
        if (high - low == 2) {
            d1 = distance(point[low], point[low+1]);
            d2 = distance(point[low+1], point[high]);
            d3 = distance(point[low], point[high]);
            if ((d1 <= d2) && (d1 <= d3)) {
                minP[0] = new Point(point[low].x, point[low].y);
                minP[1] = new Point(point[low+1].x, point[low+1].y);
                return d1;
            } else if (d2 <= d3) {
                minP[0] = new Point(point[low+1].x, point[low+1].y);
                minP[1] = new Point(point[high].x, point[high].y);
                return d2;
            } else {
                minP[0] = new Point(point[low].x, point[low].y);
                minP[1] = new Point(point[high].x, point[high].y);
                return d3;
            }
        }
        int mid = (low + high) / 2;
        d1 = closestPoint(low, mid);
        temp1[0] = minP[0];
        temp1[1] = minP[1];
        d2 = closestPoint(mid+ 1, high);
        temp2[0] = minP[0];
        temp2[1] = minP[1];
        if (d1 < d2) {
            d = d1;
            minP[0] = temp1[0];
            minP[1] = temp1[1];
        } else {
            d = d2;
            minP[0] = temp2[0];
            minP[1] = temp2[1];
        }
        for (int i = mid;i>=low && (point[mid].x - point[i].x) < d; i--) {
            p[index++] = point[i];
        }
        for (int i = mid+1;i<=high && (point[i].x - point[mid].x) < d; i++) {
            p[index++] = point[i];
        }
        Arrays.sort(p, 0, index, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return (int) (o1.y - o2.y);
            }
        });
        for (int i = 0; i < index-1; i++) {
            for (int j = i+1; j < index; j++) {
                if ((p[j].y - p[i].y) >= d) {
                    break;
                } else {
                    d3 = distance(p[i], p[j]);
                    if (d3 < d) {
                        minP[0] = new Point(p[i].x, p[i].y);
                        minP[1] = new Point(p[j].x, p[j].y);
                    }
                }
            }
        }
        return d;
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}