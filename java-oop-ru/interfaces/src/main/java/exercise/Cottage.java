package exercise;

// BEGIN
public final class Cottage implements Home {
    private final double area;
    private final int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;

    }

    @Override
    public int toCompare(Home another) {
        return compareTo(another);
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
}
// END
