package christmas.Service;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

class DiscountCalculatorTest {
    DiscountCalculator discountCalculator = new DiscountCalculator();
    @DisplayName("1~25사이의 일자를 넣으면, 해당 일자에 맞는 할인 금액을 리턴해야 합니다.")
    @Test
    public void calculateDdayDiscount() throws Exception {
        //when
        int five = discountCalculator.calculateDdayDiscount(5);
        int twenty = discountCalculator.calculateDdayDiscount(20);
        int twentyFive = discountCalculator.calculateDdayDiscount(25);

        //then
        assertEquals(five, 1400);
        assertEquals(twenty, 2900);
        assertEquals(twentyFive, 3400);
    }

    @DisplayName("1~25에 속하지 않는 일자를 넣으면 할인 금액 0이 리턴돼야 합니다.")
    @Test
    public void calculateDdayNoDiscount() throws Exception {
        //when
        int non = discountCalculator.calculateDdayDiscount(29);

        //then
        assertEquals(non, 0);
    }


    @DisplayName("예약 날이 매주 일요일이나 크리스마스 날일 경우, 추가 할인 1000이 리턴돼야 합니다.")
    @Test
    public void calculateStarDayDiscount() throws Exception {
        //given
        int firstStartSunday = 3;

        //when
        int discount1 = discountCalculator.calculateStarDayDiscount(firstStartSunday);
        int discount2 = discountCalculator.calculateStarDayDiscount(25);

        //then
        assertEquals(discount1, 1000);
        assertEquals(discount2, 1000);
    }

    @DisplayName("예약 날이 매주 일요일이나 크리스마스 날이 아닐 경우, 할인금액은 0이 리턴돼야 합니다.")
    @Test
    public void calculateNotStarDayDiscount() throws Exception {
        //given
        int firstStartTuesday = 5;

        //when
        int discount1 = discountCalculator.calculateStarDayDiscount(firstStartTuesday);

        //then
        assertEquals(discount1, 0);
    }
}