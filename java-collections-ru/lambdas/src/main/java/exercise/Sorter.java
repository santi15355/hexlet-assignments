package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class Sorted {
    public static List<String> takeOldestMans(List<Map<String, String>> usersList) {
        return usersList.stream()
                .sorted(Comparator.comparing(map -> (map.get("birthday"))))
                .filter(male -> male.get("gender").equals("male"))
                .map(name -> name.get("name"))
                .collect(Collectors.toList());
    }
}
// END
