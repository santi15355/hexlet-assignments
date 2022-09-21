package exercise;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers = List.of(3, 5, 10, 4, 9, 26, 3);
        int count = 3;
        List<Integer> actual1 = App.take(numbers, count);
        assertThat(actual1).isEqualTo(List.of(3, 5, 10));

        List<Integer> numbers2 = List.of(8, 1, 4, 4, 12, 52, 3, 8, 23, 56);
        int count2 = 7;
        List<Integer> actual2 = App.take(numbers2, count2);
        assertThat(actual2).isEqualTo(List.of(8, 1, 4, 4, 12, 52, 3));

        List<Integer> emptyList = new ArrayList<>();
        int count3 = 4;
        List<Integer> actual3 = App.take(emptyList, count3);
        assertThat(actual3).isEqualTo(List.of());
        // END
    }

}
