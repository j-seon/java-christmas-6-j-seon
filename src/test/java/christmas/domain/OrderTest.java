package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

	@DisplayName("새로운 메뉴를 구매할 때, 총 구매금액이 올라가야 합니다.")
	@Test
	void setOrderAmount() {
		//given
		Order order = new Order();
		Menu food1 = new Menu("짬뽕", 1000, "메인메뉴");
		Menu food2 = new Menu("짜장면", 2000, "메인메뉴");

		MenuOrder menuOrder = new MenuOrder(food1, 3); // +3000
		MenuOrder menuOrder2 = new MenuOrder(food2, 1); // +2000

		//when
		order.addMenuOrder(menuOrder);
		order.addMenuOrder(menuOrder2);

		//then
		assertEquals(order.getTotalAmount(), 5000);
	}

	@DisplayName("새로운 메뉴를 구매할 때, 총 구매개수가 올라가야 합니다.")
	@Test
	void setOrderQuantity() {
		//given
		Order order = new Order();
		Menu food1 = new Menu("짬뽕", 1000, "메인메뉴");
		Menu food2 = new Menu("짜장면", 2000, "메인메뉴");

		MenuOrder menuOrder = new MenuOrder(food1, 3);
		MenuOrder menuOrder2 = new MenuOrder(food2, 1);

		//when
		order.addMenuOrder(menuOrder);
		order.addMenuOrder(menuOrder2);

		//then
		assertEquals(order.getTotalOrderQuantity(), 4);
	}
}