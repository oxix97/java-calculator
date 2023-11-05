import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("요구사항 1번")
    @Test
    void givenStringWhenSplitStringThenArray() {
        //given
        String[] probs = {"1,2", "1"};
        //when
        List<String[]> answers = new ArrayList<>();
        for (String prob : probs) {
            answers.add(prob.split(","));
        }
        //then
        assertThat(answers.get(0))
                .contains("1", "2")
                .containsExactly("1", "2");

        assertThat(answers.get(1))
                .contains("1")
                .containsExactly("1");
    }

    @DisplayName("요구사항 2번")
    @Test
    void givenStringWhenSubstringThenString() {
        //given
        String prob = "(1,2)";
        //when
        String answer = prob.substring(1, 4);
        //then
        assertThat(answer)
                .isEqualTo("1,2");
    }

    @DisplayName("요구사항 3번 : StringIndexOutOfBoundsExceptionTest")
    @Test
    void givenStringWhenChatAtThenString() {
        //given

        //when

        //then
        assertThatThrownBy(() -> {
            getCharAt(10);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("out of range: 10");
//        assertThatExceptionOfType(IndexOutOfBoundsException.class)
//                .isThrownBy(() -> {
//                    getCharAt(10);
//                }).withMessageMatching("out of range: \\d+");
    }

    private char getCharAt(int size) {
        return "abc".charAt(size);
    }
}
