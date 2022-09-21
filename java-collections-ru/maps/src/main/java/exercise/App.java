package exercise;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    //public static String sentence = "";
    public static Map<String, Integer> getWordCount(String sentence) {
        var countOfWords = 0;
        String[] words = sentence.split(" ");
        Map<String, Integer> resultsMap = new HashMap<>();
        if (sentence == "") {
            return Collections.emptyMap();
        }
        for (var i = 0; i < words.length; i++) {
            if (!resultsMap.containsKey(words[i])) {
                resultsMap.put(words[i], 1);
            } else {
                countOfWords = resultsMap.get(words[i]);
                resultsMap.put(words[i], countOfWords + 1);
            }
        }
        return resultsMap;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.size() == 0) {
            return "{}";
        }
        StringBuilder mapToString = new StringBuilder();
        mapToString.append("{" + "\n");
        for (Map.Entry word : map.entrySet()) {
            mapToString.append("  " + word.getKey() + ": " + word.getValue() + "\n");
        }
        mapToString.append("}");
        return String.valueOf(mapToString);
    }
}
//END
