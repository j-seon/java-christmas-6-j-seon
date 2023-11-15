package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<MenuOrder> menuOrders;
    private final List<String[]> discountList;
    private final List<String[]> giftMenu;
    private int totalOrderQuantity = 0;
    private int totalAmount = 0;
    private int totalDiscountAmount = 0;

    public Order() {
        menuOrders = new ArrayList<>();
        discountList = new ArrayList<>();
        giftMenu = new ArrayList<>();
    }

    public int getTotalOrderQuantity() {
        return totalOrderQuantity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public List<String> getGiftMenu() {
        List<String> giftMenuStr = new ArrayList<>();
        if(giftMenu.isEmpty()) {
            giftMenuStr.add("없음");
            return giftMenuStr;
        }
        for(String[] gift : giftMenu) {
            if(gift[0] != "" && gift[0] != null) {
                giftMenuStr.add(gift[0] +" "+ gift[1] + "개");
            }
        }
        return giftMenuStr;
    }

    public List<String> getDiscountList() {
        List<String> discount = new ArrayList<>();
        if(discountList.isEmpty()) {
            discount.add("없음");
            return discount;
        }
        for(String[] discountInfo : discountList) {
            if(discountInfo[0] != "" && discountInfo[0] != null) {
                discount.add(discountInfo[0] +": -"+ discountInfo[1] + "원");
            }
        }
        return discount;
    }

    public int getMenuOrdersCount() {
        return menuOrders.size();
    }
    public void addMenuOrder(MenuOrder menuOrder) {
        setOrderAmountAndQuantity(menuOrder);
        menuOrders.add(menuOrder);
    }
    public void addDiscountList (String[] discountInfo) {
        discountList.add(discountInfo);
    }

    public void setGiftMenu(String name, int quantity) {
        giftMenu.add(new String[]{name, "" + quantity});
    }
    public void setTotalDiscountAmount(int discountAmount) {
        totalDiscountAmount += discountAmount;
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

    public List<Integer> getOrderQuantityList() {
        List<Integer> orderQuantity = new ArrayList<>();
        for (MenuOrder menuOrder : menuOrders) {
            orderQuantity.add(menuOrder.getQuantity());
        }
        return orderQuantity;
    }

    public List<String> getCategoryList() {
        List<String> orderCategory = new ArrayList<>();
        for (MenuOrder menuOrder : menuOrders) {
            orderCategory.add(menuOrder.getMenu().getCategory());
        }
        return orderCategory;
    }
}
