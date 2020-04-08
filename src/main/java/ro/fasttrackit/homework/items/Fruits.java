package ro.fasttrackit.homework.items;

import ro.fasttrackit.homework.Category;
import ro.fasttrackit.homework.ItemValidator;
import ro.fasttrackit.homework.ShopItem;

import java.util.Objects;

public class Fruits implements ShopItem {
    private final String name;
    private int price;
    private Category category;

    public Fruits(String name, int price, Category category) {
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
        Fruits fruits = (Fruits) o;
        return price == fruits.price &&
                Objects.equals(name, fruits.name) &&
                category == fruits.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category);
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "name = " + name +
                ", price = " + price +
                ", category = " + category +
                '}';
    }
}
