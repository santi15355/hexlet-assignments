package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;


class AppTest {

    @Test
    void testBuildAppartmentsList1() {
        List<Home> appartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> expected = new ArrayList<>(List.of(
                "Квартира площадью 44.0 метров на 10 этаже",
                "Квартира площадью 90.0 метров на 2 этаже",
                "2 этажный коттедж площадью 125.5 метров"
        ));

        List<String> result = App.buildAppartmentsList(appartments, 3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testBuildAppartmentsList2() {
        List<Home> appartments = new ArrayList<>(List.of(
                new Cottage(100, 1),
                new Flat(190, 10, 2),
                new Flat(180, 30, 5),
                new Cottage(250, 3)
        ));

        List<String> expected = new ArrayList<>(List.of(
                "1 этажный коттедж площадью 100.0 метров",
                "Квартира площадью 200.0 метров на 2 этаже",
                "Квартира площадью 210.0 метров на 5 этаже",
                "3 этажный коттедж площадью 250.0 метров"
        ));

        List<String> result = App.buildAppartmentsList(appartments, 4);
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void testBuildAppartmentsList3() {
        List<Home> appartments = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        List<String> result = App.buildAppartmentsList(appartments, 10);
        assertThat(result).isEqualTo(expected);
    }

    // BEGIN
    @Test
    void testToString() {
        CharSequence text = new ReversedSequence("abcdef");
        var result = text.toString();
        var expected = "fedcba";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testCharAt() {
        CharSequence text = new ReversedSequence("abcdef");
        var result = text.charAt(1);
        var expected = 'e';
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testSubString() {
        CharSequence text = new ReversedSequence("abcdef");
        var result = text.subSequence(1, 4);
        var expected = "edc";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testToCompare1() {
        Flat flat = new Flat(45, 5, 3);
        Cottage cottage = new Cottage(150, 7);
        var result = flat.toCompare(cottage);
        var expected = -1;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testToCompare2() {
        Flat flat1 = new Flat(200, 5, 3);
        Flat flat2 = new Flat(17, 3, 1);
        var result = flat1.toCompare(flat2);
        var expected = 1;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testToCompare3() {
        Flat flat = new Flat(200, 5, 3);
        Cottage cottage = new Cottage(205, 2);
        var result = flat.toCompare(cottage);
        var expected = 0;
        assertThat(result).isEqualTo(expected);
    }
    // END
}
