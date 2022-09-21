package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        List<String> cuttedEmails = new ArrayList<>();
        for (var i = 0; i < emails.size(); i++) {
            cuttedEmails.add(String.valueOf(emails.get(i).split("@")[1]));
        }
        return (int) cuttedEmails.stream()
                .filter(x -> x.equals("yandex.ru") || x.equals("gmail.com") || x.equals("hotmail.com"))
                .count();
    }
}
// END
