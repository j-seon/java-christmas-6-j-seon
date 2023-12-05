package christmas.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("빈 값이나 띄어쓰기가 들어간 문자열을 받을 경우 false를 반환해야 합니다.")
    @Test
    void isValidInput() {
        //given
        InputValidator inputValidator = new InputValidator();

        //when & then
        assertFalse(inputValidator.isValidInput(""));
        assertFalse(inputValidator.isValidInput("31 "));
    }
}