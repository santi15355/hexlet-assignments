package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> resultMap = new LinkedHashMap<>();
        for (Map.Entry<String, Object> key : data1.entrySet()) {
            if (data2.containsKey(key.getKey())) {
                if (data2.containsValue(key.getValue())) {
                    resultMap.put(key.getKey(), "unchanged");
                } else {
                    resultMap.put(key.getKey(), "changed");
                }
            } else {
                resultMap.put(key.getKey(), "deleted");
            }
        }
        for (Map.Entry<String, Object> key2 : data2.entrySet()) {
            if (!data1.containsKey(key2.getKey())) {
                resultMap.put(key2.getKey(), "added");
            }
        }
        return resultMap;
    }
}
//END
