package christmas.domain;

import java.util.Objects;

public class Menu {
    private final String name;
    private final int price;
    private final String category;
    public Menu(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }


    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Menu)) {
            return false;
        }

        Menu menu = (Menu) o;
        return name == menu.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
