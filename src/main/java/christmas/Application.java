package christmas;

import christmas.controller.OrderController;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        OrderController orderController = config.getOrderController();
        orderController.run();
    }
}
