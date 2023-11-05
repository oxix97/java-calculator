import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항 1 테스트")
    @Test
    void givenSetWhenGetSizeThenNumber() {
        //given

        //when
        int size = numbers.size();
        //then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("요구사항 2 테스트")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void givenSetWhenGetParameterSizeThenTrue(Integer input) {
        //given

        //when
        boolean isContained = numbers.contains(input);
        //then
        assertTrue(isContained);
    }

    @DisplayName("요구사항 3 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @ParameterizedTest
    void givenSetWhenGetParameterSizeThenBoolean(Integer input, String expected) {
        //given

        //when
        String actual = String.valueOf(numbers.contains(input));
        //then
        assertEquals(expected, actual);
    }
}
