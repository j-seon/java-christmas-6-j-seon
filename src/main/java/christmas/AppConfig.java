package christmas;

import christmas.Service.OrderService;
import christmas.controller.OrderController;
import christmas.domain.MenuBoard;
import christmas.validator.OrderValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;

public class AppConfig {
	private final MenuBoard menuBoard;
	private final OutputView outputView;
	private final InputView inputView;

	private final OrderValidator orderValidator;
	private final OrderService orderService;
	private final OrderController orderController;

	public AppConfig() {
		menuBoard = new MenuBoard(new HashMap());
		outputView = new OutputView();
		inputView = new InputView();

		orderValidator = new OrderValidator(menuBoard);
		orderService = new OrderService(menuBoard, orderValidator);
		orderController = new OrderController(outputView,inputView,orderService);
	}
	public OrderController getOrderController() {
		return orderController;
	}
}
