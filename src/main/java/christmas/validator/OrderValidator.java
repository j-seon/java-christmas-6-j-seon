package christmas.validator;

import christmas.domain.MenuBoard;
import christmas.domain.Order;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static christmas.enums.ErrorMessage.*;
import static christmas.enums.OrderRelatedNumbers.MAX_ORDER_QUANTITY;
import static christmas.enums.OrderRelatedNumbers.MIN_ORDER_AMOUNT;

public class OrderValidator {
    private final MenuBoard menuBoard;

    public OrderValidator(MenuBoard menuBoard) {
        this.menuBoard = menuBoard;
    }


    public boolean isValidOrderFormat(String[] menuInfo, Order order) {
        try {
            if (menuInfo.length != 2) {
                throw new IllegalArgumentException(INVALID_ORDER_ERROR.getMessage());
            }
            if (isNotMatchMenuFormat(menuInfo)) {
                throw new IllegalArgumentException(INVALID_ORDER_ERROR.getMessage());
            }
            if (isOverMinOrderLimit(Integer.parseInt(menuInfo[1]))) {
                throw new IllegalArgumentException(INVALID_ORDER_ERROR.getMessage());
            }
            if (isDuplicateMenu(menuInfo[0], order)) {
                throw new IllegalArgumentException(INVALID_ORDER_ERROR.getMessage());
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean isValidOrder(Order order) {
        try {
            if (order.getMenuOrdersCount() == 0 ) {
                throw new IllegalArgumentException(INVALID_ORDER_ERROR.getMessage());
            }
            if (isOverMaxOrderLimit(order.getTotalOrderQuantity())) {
                throw new IllegalArgumentException(OVER_MAX_ORDER_LIMIT_ERROR.getMessage());
            }
            if (isBeverageOnlyOrder(order)) {
                throw new IllegalArgumentException(BEVERAGE_ONLY_ORDER_ERROR.getMessage());
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    private boolean isOverMaxOrderLimit(int quantity) {
        return quantity > MAX_ORDER_QUANTITY.getNumber();
    }

    private boolean isBeverageOnlyOrder (Order order) {
        List<String> orders = order.getOrderNameList();
        for (String menuName : orders) {
            if(menuBoard.findMenu(menuName).getCategory() != "음료") {
                return false;
            }
        }
        return true;
    }

    private boolean isMenuExistence(String menuName) {
        if(menuBoard.findMenu(menuName) == null) {
            return true;
        }
        return false;
    }

    private boolean isNotMatchMenuFormat(String[] menuInfo) {
        return menuInfo.length != 2
                || isMenuExistence(menuInfo[0])
                || !menuInfo[1].matches("[0-9]+");
    }

    private boolean isDuplicateMenu(String menuName, Order order) {
        return order.getOrderQuantity(menuName) > 0;
    }

    private boolean isOverMinOrderLimit(int count) {
        return count < 1;
    }

}
