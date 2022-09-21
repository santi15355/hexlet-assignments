package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> whatToFind) {
        boolean foundFlag;
        List<Map<String, String>> result = new ArrayList<>();
        for (var book : books) {
            foundFlag = true;
            for (Map.Entry<String, String> findParam : whatToFind.entrySet()) {
                if (!book.get(findParam.getKey()).equals(findParam.getValue())) {
                    foundFlag = false;
                }
            }
            if (foundFlag) {
                result.add(book);
            }
        }
        return result;
    }
}
