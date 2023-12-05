package christmas.Service;

import christmas.domain.Menu;
import christmas.domain.MenuBoard;
import christmas.domain.MenuOrder;
import christmas.domain.Order;
import christmas.validator.OrderValidator;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final MenuBoard menuBoard;
    private final OrderValidator orderValidator;

    public OrderService(MenuBoard menuBoard, OrderValidator orderValidator) {
        this.menuBoard = menuBoard;
        this.orderValidator = orderValidator;
    }

    public Order validateAndSaveOrder(String input) {
        List<String> menuOrderStrings = splitMenuListByComma(input);
        Order order = new Order();
        for (String menuString : menuOrderStrings) {
            String[] menuInfo = extractMenuNameAndQuantity(menuString);

            if (!orderValidator.isValidOrderFormat(menuInfo, order)) {
                return null;
            }
            saveMenuOrder(menuInfo, order);
        }
        if(!orderValidator.isValidOrder(order)) {
            return null;
        }
        return order;
    }

    public String getEventBadgeStatus(Order order) {
        int totalDiscount = order.getTotalDiscountAmount();
        if(totalDiscount > 5000) {
            return "별";
        }
        if(totalDiscount > 10000) {
            return "트리";
        }
        if(totalDiscount > 20000) {
            return "산타";
        }
        return "없음";
    }

    public List<String> splitMenuListByComma(String input) {
        List<String> menu = new ArrayList();
        menu.addAll(List.of(input.split(",")));

        return menu;
    }
    public String[] extractMenuNameAndQuantity(String input) {
        return input.split("-");
    }

    private Order saveMenuOrder(String[] menuInfo, Order order) {
        String menuName = menuInfo[0];
        int quantity = Integer.parseInt(menuInfo[1]);

        Menu menu = menuBoard.findMenu(menuName);

        MenuOrder menuOrder = new MenuOrder(menu, quantity);
        order.addMenuOrder(menuOrder);
        return order;
    }

}
