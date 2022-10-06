package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

// BEGIN
@Data
@AllArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    @SneakyThrows
    public static String serialize(Car car) {
        ObjectMapper data = new ObjectMapper();
        return data.writeValueAsString(car);
    }

    @SneakyThrows
    public static Car unserialize(String json) {
        ObjectMapper data = new ObjectMapper();
        return data.readValue(json, Car.class);
    }
    // END
}
