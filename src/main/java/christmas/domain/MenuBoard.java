package christmas.domain;

import java.util.HashMap;

public class MenuBoard {
    private final HashMap<String, Menu> menuBoard;
    public MenuBoard(HashMap menuBoard) {
        this.menuBoard = menuBoard;
        initMenu();
    }

    private void initMenu() {
        menuBoard.put("양송이수프", new Menu("양송이수프", 6000, "애피타이저"));
        menuBoard.put("타파스", new Menu("타파스", 5500, "애피타이저"));
        menuBoard.put("시저샐러드", new Menu("시저샐러드", 800, "애피타이저"));

        menuBoard.put("티본스테이크", new Menu("티본스테이크", 55000, "메인"));
        menuBoard.put("바비큐립", new Menu("바비큐립", 54000, "메인"));
        menuBoard.put("해산물파스타", new Menu("해산물파스타", 35000, "메인"));

        menuBoard.put("초코케이크", new Menu("초코케이크", 15000, "디저트"));
        menuBoard.put("아이스크림", new Menu("아이스크림", 5000, "디저트"));

        menuBoard.put("제로콜라", new Menu("제로콜라", 3000, "음료"));
        menuBoard.put("레드와인", new Menu("레드와인", 60000, "음료"));
        menuBoard.put("샴페인", new Menu("샴페인", 25000, "음료"));
    }

    public int getPrice(String menuName) {
        return findMenu(menuName).getPrice();
    }
    public String getCategory(String menuName) {
        return findMenu(menuName).getCategory();
    }

    public Menu findMenu(String menuName) {
        if(menuBoard.containsKey(menuName)) {
            return menuBoard.get(menuName);
        }
        return null;
    }
}
