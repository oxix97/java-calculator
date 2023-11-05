import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @DisplayName("Valid Data Test")
    @CsvSource(value = {
            "1:1",
            "1,2:3",
            "1,2,3:6",
            "2,3,4:9",
            "1,2,3,4,5,6,7,8,9,10:55"
    }, delimiter = ':'
    )
    @ParameterizedTest
    void givenValidInputWhenSplitThenSumThenNumber(String input, Integer expected) {
        //given
        //when
        int actual = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
        //then
        assertThat(expected)
                .isEqualTo(actual);

    }

    @DisplayName("Valid data custom delimiter Test")
    @CsvSource(value = {
            "1//1",
            "1,2//3",
            "1,2,3//6",
            "2,3,4//9",
            "1,2,3,4,5,6,7,8,9,10//55"
    }, delimiterString = "//"
    )
    @ParameterizedTest
    void givenValidInputAndCustomDelimiterWhenSplitThenSumThenNumber(String input, Integer expected) {
        //given
        //when
        int actual = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
        //then
        assertThat(expected)
                .isEqualTo(actual);

    }

    @DisplayName("Invalid data test")
    @ValueSource(strings = {"1,-2,3", "1,a,4", "1,2,3,4,5,-1"})
    @ParameterizedTest
    void givenInValidInputWhenSplitThenException(String input) {
        //given

        //when
        Executable executable = () -> splitAndSum(input);
        //then
        assertThrows(RuntimeException.class, executable);
    }

    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        List<String> numbers = Arrays.asList(input.split(",|:"));

        int sum = 0;
        for (String number : numbers) {
            int n = Integer.parseInt(number);
            if (n < 0) {
                throw new RuntimeException("음수를 입력할 수 없습니다.");
            }
            sum += n;
        }

        return sum;
    }
}
