package exercise;

// BEGIN
public final class Flat implements Home {

    private final double area;
    private final double balconyArea;
    private final int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;

    }

    @Override
    public int toCompare(Home another) {
        return compareTo(another);
    }


    public String toString() {
        var generalArea = area + balconyArea;
        return "Квартира площадью " + generalArea
                + " метров на " + getFloor() + " этаже";
    }
}
// END
