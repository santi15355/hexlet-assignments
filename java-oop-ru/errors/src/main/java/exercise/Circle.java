package exercise;

import java.text.DecimalFormat;

// BEGIN
class Circle {
    private final Point point;
    private final int radius;

    Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return round(Math.PI * (radius * radius));
    }
    private static double round(double data) {
        DecimalFormat rounder = new DecimalFormat("#.###");
        String number = rounder.format(data).replace(",", ".");
        return Double.parseDouble(number);
    }
}
// END
