package christmas.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateValidatorTest {

    @DisplayName("1~31 사이의 숫자외의 값이 들어온다면 false를 반환해야 합니다.")
    @Test
    public void isValidDate() throws Exception {
        //given
        DateValidator dateValidator = new DateValidator();

        //when & then
        assertFalse(dateValidator.isValidDate("31일"));
        assertFalse(dateValidator.isValidDate("abc"));
        assertFalse(dateValidator.isValidDate("37"));
    }
}