package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
class Tag {
    private final String name;
    private final Map<String, String> attributes;

    Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String attributesToString() {
        return attributes.keySet().stream()
                .map(key -> {
                    String value = attributes.get(key);
                    return String.format(" %s=\"%s\"", key, value);
                })
                .collect(Collectors.joining(""));
    }

    public String getName() {
        return name;
    }
}
// END
