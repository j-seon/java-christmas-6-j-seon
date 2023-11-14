package christmas.controller;

import christmas.Service.OrderService;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {

    private final OutputView outputView;
    private final InputView inputView;
    private final OrderService orderService;

    public OrderController(OutputView outputView, InputView inputView, OrderService orderService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.orderService = orderService;
    }
    public void run() {
        outputView.printIntroduction();
        int reservationDate = inputView.readDate();

        Order order = getOrder();

    }

    public Order getOrder() {
        boolean validOrder = false;
        String orders = inputView.readOrder();
        while(!validOrder) {
            Order order = orderService.validateAndSaveOrder(orders);
            if(order != null) {
                return order;
            }
            orders = inputView.readUserInput();
        }
        return null;
    }
}
