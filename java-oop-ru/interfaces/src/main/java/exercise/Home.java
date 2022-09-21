package exercise;

// BEGIN
public interface Home {
    double getArea();

    int toCompare(Home another);

    default int compareTo(Home another) {
        return Double.compare(getArea(), another.getArea());
    }

}

// END
