package OOP;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double distance (int x, int y) {
        int dx = this.x - x;
        int dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    double distance (Point p) {
        return distance(p.x, p.y);
    }
}

class Point3D extends Point {
    int z;
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    Point3D() {
        this(-1, -1, -1);
    }
    double distance(int x, int y, int z) {
        int dx = this.x = x;
        int dy = this.y - y;
        int dz = this.z - z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
    double distance(Point3D other) {
        return distance(other.x, other.y, other.z);
    }

    double distance(int x, int y) {
        int dx = this.x = x;
        int dy = this.y = y;
        int dz = 0;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}

public class Points {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(50, 90);
        System.out.println("x = " + p1.x + " y = " + p1.y);
        System.out.println("x = " + p2.x + " y = " + p2.y);
        System.out.println(p1.distance(p2));
        var p3 = new Point3D(1, 2, 3);
        System.out.println(p3.distance(10, 10));
    }
}


