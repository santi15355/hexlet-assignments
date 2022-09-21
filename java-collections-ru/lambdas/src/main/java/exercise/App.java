package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .flatMap(enLarge -> Stream.of(horizontalCopy(enLarge), horizontalCopy(enLarge)))
                .toArray(String[][]::new);
    }

    private static String[] horizontalCopy(String[] image) {
        return Arrays.stream(image).flatMap(row -> Stream.of(row, row)).toArray(String[]::new);
    }

}
// END
