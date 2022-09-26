package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void testFile() {
        Map<String, String> map = new HashMap<>(Map.of("test1", "testValue"));
        KeyValueStorage file = new FileKV(filepath.toString(), map);
        file.set("hello", "world");

        String expected = "{test1=testValue, hello=world}";
        String actual = Utils.readFile("src/test/resources/file");

        Assertions.assertEquals(expected, actual);
    }
    // END
}
