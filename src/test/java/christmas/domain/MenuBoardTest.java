package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuBoardTest {

    MenuBoard menuBoard = new MenuBoard(new HashMap());
    @DisplayName("메뉴이름을 입력할 시, 메뉴의 가격이 나와야 한다.")
    @Test
    void getPrice() {
        //when
        int price = menuBoard.getPrice("양송이수프");

        //then
        assertThat( price== 6000);
    }

    @DisplayName("존재하지 않는 메뉴 이름을 입력할 시, NullPointException이 발생해야 한다.")
    @Test
    void getPriceNullTest() {
        //when & then
        assertThrows(NullPointerException.class, () -> {
            menuBoard.getPrice("왕감자");
        });
    }

}