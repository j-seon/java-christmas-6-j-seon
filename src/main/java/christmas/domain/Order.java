package christmas.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {
    private final List<MenuOrder> menuOrders = new ArrayList<>();
    private int totalOrderQuantity = 0;
    private int totalAmount = 0;
    private int totalDiscountAmount = 0;
    public int getTotalOrderQuantity() {
        return totalOrderQuantity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }


    public int getMenuOrdersCount() {
        return menuOrders.size();
    }
    public void addMenuOrder(MenuOrder menuOrder) {
        setOrderAmountAndQuantity(menuOrder);
        menuOrders.add(menuOrder);
    }
    private void setOrderAmountAndQuantity(MenuOrder menuOrder) {
        int menuPrice = menuOrder.getMenu().getPrice();
        int menuOrderQuantity = menuOrder.getQuantity();

        totalAmount += (menuPrice * menuOrderQuantity);
        totalOrderQuantity += menuOrder.getQuantity();
    }
    public int getOrderQuantity(String menuName) {
        return menuOrders.stream()
                .filter(menuOrder -> menuOrder.getMenu().getName().equals(menuName))
                .mapToInt(MenuOrder::getQuantity)
                .findFirst()
                .orElse(-1);
    }
    public List<String> getOrderNameList() {
        List<String> orderNames = new ArrayList<>();
        for (MenuOrder menuOrder : menuOrders) {
            orderNames.add(menuOrder.getMenu().getName());
        }
        return orderNames;
    }
}
