package exercise;

// BEGIN
public final class Segment {
    private final Point point1;
    private final Point point2;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getMidPoint() {
        return new Point((point1.getX() + point2.getX()) / 2,
                (point1.getY() + point2.getY()) / 2);

    }
}
// END
