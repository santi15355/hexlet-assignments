package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    private Map<String, String> map;

    public InMemoryKV(Map<String, String> map) {
        this.map = new HashMap<>(map);
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
        /*if (!map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.replace(key, value);
        }*/
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(map);
    }
}
// END
