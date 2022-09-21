package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class App {
    public static boolean scrabble(String letters, String word) {
        List<String> symbols = new ArrayList<String>(Arrays.asList(letters.toLowerCase().split("")));
        if (letters.length() == 0) {
            return false;
        }
        for(var i = 0; i < word.length(); i++) {
            int indexOfLetter = symbols.indexOf(String.valueOf(word.toLowerCase().charAt(i)));
            if (indexOfLetter != -1) {
                symbols.remove(indexOfLetter);
            } else {
                return false;
            }
        }
        return true;
    }
}
