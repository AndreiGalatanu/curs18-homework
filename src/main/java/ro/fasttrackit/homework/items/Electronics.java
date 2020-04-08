package ro.fasttrackit.homework.items;

import ro.fasttrackit.homework.Category;
import ro.fasttrackit.homework.ItemValidator;
import ro.fasttrackit.homework.ShopItem;

import java.util.Objects;

public class Electronics implements ShopItem {
    private final String name;
    private int price;
    private Category category;

    public Electronics(String name, int price, Category category) {
        var validator = new ItemValidator();
        validator.verify(name, price, category);
        this.name = name;
        this.price = price;
        this.category = category;
    }


    @Override
    public String name() {
        return this.name;
    }

    @Override
    public int price() {
        return this.price;
    }

    @Override
    public Category category() {
        return this.category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return price == that.price &&
                Objects.equals(name, that.name) &&
                category == that.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category);
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "name = " + name +
                ", price = " + price +
                ", category = " + category +
                '}';
    }
}
