package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage another) {
        Map<String, String> result = another.toMap().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        for (Map.Entry<String, String> keys : another.toMap().entrySet()) {
            another.unset(keys.getKey());
        }

        for (Map.Entry<String, String> entry : result.entrySet()) {
            another.set(entry.getKey(), entry.getValue());
        }
    }
}
// END
