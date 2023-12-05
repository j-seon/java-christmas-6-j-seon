package christmas.view;

import christmas.Service.FormatService;
import christmas.domain.Order;

import java.util.List;

public class OutputView {
    FormatService formatService;

    public OutputView() {
        formatService = new FormatService();
    }

    public void printIntroduction() {
        final int month = 12;
        System.out.println("안녕하세요! 우테코 식당 " + month + "월 이벤트 플래너입니다.");
    }

    public void printOrderStatement(Order order) {
        System.out.println("<주문 메뉴>");
        printMenuOrder(order);
        System.out.println();

        System.out.println("<할인 전 총주문 금액>");
        System.out.println(order.getTotalAmount() + "원");
    }

    public void printDiscountStatement(Order order, String badge) {
        printGiftMenu(order);
        System.out.println();

        printDiscountList(order);
        System.out.println();

        printTotalDiscountAmount(order);
        System.out.println();

        printAmountAfterDiscount(order);
        System.out.println();

        printEventBadge(badge);
    }

    public void printAmountAfterDiscount(Order order) {
        System.out.println("<할인 후 예상 결제 금액>");
        int originAmount = order.getTotalAmount();
        int discountAmount = order.getTotalDiscountAmount();

        int amountAfterDiscount = originAmount - discountAmount;

        System.out.println(formatService.addThousandSeparator(amountAfterDiscount));
    }

    public void printTotalDiscountAmount(Order order) {
        System.out.println("<총혜택 금액>");
        int discount = order.getTotalDiscountAmount();
        if (discount == 0) {
            System.out.println("0원");
            return;
        }
        System.out.println("-" + discount + "원");
    }

    private void printMenuOrder(Order order) {
        List<String> orderNames = order.getOrderNameList();
        List<Integer> orderQuantity = order.getOrderQuantityList();

        for (int i = 0; i < orderNames.size(); i++) {
            System.out.println(orderNames.get(i) + " " + orderQuantity.get(i) + "개");
        }
    }

    public void printGiftMenu(Order order) {
        System.out.println("<증정 메뉴>");

        List<String> giftMenus = order.getGiftMenu();
        printList(giftMenus);
    }

    public void printDiscountList(Order order) {
        System.out.println("<혜택 내역>");

        List<String> discountList = order.getDiscountList();
        printList(discountList);
    }

    public void printList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void printEventBadge(String badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }
}
