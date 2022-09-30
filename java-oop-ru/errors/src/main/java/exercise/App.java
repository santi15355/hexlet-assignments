package exercise;

import java.text.DecimalFormat;

// BEGIN
class App {
    public static void printSquare(Circle circle) {
        try {
            System.out.println(round(circle.getSquare()));
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        }
        System.out.println("Вычисление окончено");
    }
    private static int round(double data) {
        DecimalFormat rounder = new DecimalFormat("#");
        String number = rounder.format(data).replace(",", ".");
        return Integer.parseInt(number);
    }
}
// END
