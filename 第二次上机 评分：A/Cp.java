public class Cp {
    static Point[] point;
    static Point[] minP = new Point[2];
    public static void main(String[] args) {
        int n = 100;
        point = new Point[n];
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * 100);
            int b = (int) (Math.random() * 100);
            point[i] = new Point(a, b);
        }
        double min=distance(point[0],point[1]);
        for(int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if(min>distance(point[i],point[j])){
                    min=distance(point[i],point[j]);
                }
            }
        }
        for(int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if(min==distance(point[i],point[j])){
                    System.out.println(point[i].x+","+point[i].y);
                    System.out.println(point[j].x+","+point[j].y);
                }
            }
        }
        System.out.println(min);
    }
    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
