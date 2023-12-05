package christmas.validator;

import christmas.domain.MenuBoard;
import christmas.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OrderValidatorTest {
	MenuBoard menuBoard = new MenuBoard(new HashMap());
	OrderValidator orderValidator = new OrderValidator(menuBoard);

	@DisplayName("주문양식에 맞는 경우 ture를 반환해야 합니다.")
	@Test
	void isValidOrderFormat() {
		//given
		String[] menuInfo1 = new String[]{"양송이수프", "10"};

		//then
		boolean result1 = orderValidator.isValidOrderFormat(menuInfo1, new Order());

		//when
		assertTrue(result1);
	}
	@DisplayName("주문양식과 맞지 않는 경우 false를 반환해야 합니다.")
	@Test
	void isValidOrderFormatFalseTest() {
		//given
		String[] menuInfo1 = new String[]{"안사요"};
		String[] menuInfo2 = new String[]{"헤이즐넛라떼", "1"};
		String[] menuInfo3 = new String[]{"양송이수프", "3개"};
		String[] menuInfo4 = new String[]{"양송이수프", "33", "많이 주세요"};
		String[] menuInfo5 = new String[]{""};
		String[] menuInfo6 = null;

		//then
		boolean result1 = orderValidator.isValidOrderFormat(menuInfo1, new Order());
		boolean result2 = orderValidator.isValidOrderFormat(menuInfo2, new Order());
		boolean result3 = orderValidator.isValidOrderFormat(menuInfo3, new Order());
		boolean result4 = orderValidator.isValidOrderFormat(menuInfo4, new Order());
		boolean result5 = orderValidator.isValidOrderFormat(menuInfo5, new Order());
		boolean result6 = orderValidator.isValidOrderFormat(menuInfo6, new Order());

		//when
		assertFalse(result1);
		assertFalse(result2);
		assertFalse(result3);
		assertFalse(result4);
		assertFalse(result5);
		assertFalse(result6);
	}

	@Test
	void isValidOrder() {
	}
}