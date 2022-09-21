package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildAppartmentsList(List<Home> apartment, int count) {
        return apartment.stream()
                .sorted(Home::toCompare)
                .limit(count)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
// END
