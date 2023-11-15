package christmas.Service;
import christmas.domain.Order;

import java.util.List;

import static christmas.enums.OrderRelatedNumbers.THIS_YEAR_DECEMBER_FIRST_SUNDAY;

/*
  - [ ] 일~목 디저트 메뉴 1개당 2,023 할인
  - [ ] 금~토 메인 메뉴 1개당 2,023 할인
    - [ ] 날짜와 카테고리를 확인하여 해당 날짜 + 카테고리에 속한다면 할인 총 할인 금액 증가
  - [ ] 날짜에 별이 있으면 1,000 할인
    - [ ] 매주 일요일(3일, 3일 + 7의배수일)과 25일은 1,000원 추가 할인
  - [ ] 할인 전 총 주문금액 12만원 이상, 샴페인 1개(25,000원) 증정

 */
public class DiscountCalculator {

	public void calculateDiscount(int date, Order order) {
		if(order.getTotalAmount() < 10000) {
			return;
		}
		int dDayDiscount = calculateDdayDiscount(date);
		saveDiscountList(order, dDayDiscount, "크리스마스 디데이 할인");

		int starDayDiscount = calculateStarDayDiscount(date, order);
		saveDiscountList(order, starDayDiscount, "특별 할인");

		String weekendStatus = calculateWeekendStatus(date);
		int weekDiscount = calculateWeekDiscount(date, order, weekendStatus);
		saveDiscountList(order, weekDiscount, weekendStatus + " 할인");

		// 12만원 이상 주문에 대한 보너스 샴페인
		int bonusChampagne = calculateBonusChampagne(order);
		if(bonusChampagne > 0) {
			order.setGiftMenu("샴페인", 1);
			saveDiscountList(order, bonusChampagne, "증정 이벤트");
		}
	}

	private int calculateDdayDiscount(int date) {
		final int START_DDAY_EVENT_DAY = 1;
		final int END_DDAY_EVENT_DAY = 25;
		final int DEFAULT_DISCOUNT = 1000;
		final int PLUS_DISCOUNT = 100;

		if (date >= START_DDAY_EVENT_DAY && date <= END_DDAY_EVENT_DAY) {
			int discount = DEFAULT_DISCOUNT + ((date - 1) * PLUS_DISCOUNT);
		}
		return 0;
	}

	private int calculateStarDayDiscount(int date, Order order) {
		// 일요일 및 25일 추가 할인
		final int CHRISTMAS_DAY = 25;
		if (isSunday(date) || date == CHRISTMAS_DAY) {
			return 1000;
		}
		return 0;
	}

	private int calculateWeekDiscount(int date, Order order, String weekendStatus) {
		int totalDiscount = 0;
		if (weekendStatus.equals("평일")) {
			totalDiscount = calculateCategoryDiscount(order, "디저트", 2023);
		}
		if (weekendStatus.equals("주말")) {
			totalDiscount = calculateCategoryDiscount(order, "메인", 2023);
		}
		return totalDiscount;
	}


	private int calculateCategoryDiscount(Order order, String category, int discount) {
		List<String> orderCategoryList = order.getCategoryList();
		int totalDiscount = 0;
		for(String orderCategory : orderCategoryList) {
			if(orderCategory.equals(category)) {
				totalDiscount += discount;
			}
		}
		return totalDiscount;
	}

	private int calculateBonusChampagne(Order order) {
		if (order.getTotalAmount() >= 120000) {
			return 25000;
		}
		return 0;
	}

	private boolean isSunday(int date) {
		return date % 7 == THIS_YEAR_DECEMBER_FIRST_SUNDAY.getNumber();
	}
	private String calculateWeekendStatus(int date) {
		// 0: 일요일, 6: 토요일
		int dayOfWeek = (date + THIS_YEAR_DECEMBER_FIRST_SUNDAY.getNumber() - 1) % 7;
		boolean weekdayDiscount = dayOfWeek >= 0 && dayOfWeek <= 4;

		if (weekdayDiscount) {
			return "평일";
		}
		return "주말";
	}

	private void saveDiscountList(Order order, int discount, String message) {
		FormatService formatService = new FormatService();
		if(discount > 0) {
			order.setTotalDiscountAmount(discount);
			order.addDiscountList(new String[]{message, formatService.addThousandSeparator(discount)});
		}
	}
}
