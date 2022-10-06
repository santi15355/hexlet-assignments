package exercise;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    @SneakyThrows
    public static void save(Path path, Car car) {
        String data = Car.serialize(car);
        Files.writeString(path, data, StandardOpenOption.WRITE);
    }

    @SneakyThrows
    public static Car extract(Path path) {
        String data = Files.readString(path);
        return Car.unserialize(data);
    }
}
// END
