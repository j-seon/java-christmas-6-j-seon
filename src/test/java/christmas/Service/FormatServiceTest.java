package christmas.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FormatServiceTest {

    @DisplayName("숫자를 넣으면 1000단위당 ','를 넣은 String을 반환해야 합니다.")
    @Test
    public void addThousandSeparator() throws Exception {
        //given
        FormatService formatService = new FormatService();

        //when
        String string = formatService.addThousandSeparator(10000);

        //then
        assertEquals(string, "10,000");
    }
}