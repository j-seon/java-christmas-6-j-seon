package christmas.enums;

public enum OrderRelatedNumbers {
	MAX_ORDER_QUANTITY(20),
	MIN_ORDER_AMOUNT(10000),
	THIS_YEAR_DECEMBER_FIRST_SUNDAY(3);



	private int number;
	OrderRelatedNumbers (int number) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
}
