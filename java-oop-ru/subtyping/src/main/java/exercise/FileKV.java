package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filePath;
    private Map<String, String> map;

    public FileKV(String filePath, Map<String, String> map) {
        this.filePath = filePath;
        this.map = map;
        Utils.writeFile(filePath, map.toString());
        Utils.serialize(map);
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
        Utils.writeFile(filePath, map.toString());
    }

    @Override
    public void unset(String key) {
        map.remove(key);
        Utils.writeFile(filePath, map.toString());
    }

    @Override
    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return map;
    }
}
// END
