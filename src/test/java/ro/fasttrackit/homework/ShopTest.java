package ro.fasttrackit.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ro.fasttrackit.homework.items.Clothes;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static ro.fasttrackit.homework.Category.*;

class ShopTest<T extends ShopItem> {
    Shop<T> shop;

    @BeforeEach
    void setup() {
        shop = new Shop<>();
    }

    @Test
    @DisplayName("WHEN item with invalid name is added THEN exception is thrown")
    void invalidItemName() {
        assertThrows(IllegalArgumentException.class, () -> shop.addItem((T) new Clothes("", 60, ON_SALE)));
    }

    @Test
    @DisplayName("WHEN item with invalid price is added THEN exception is thrown")
    void invalidPriceItem() {
        assertThrows(IllegalArgumentException.class, () -> shop.addItem((T) new Clothes("shirt", -60, ON_SALE)));
    }

    @Test
    @DisplayName("WHEN item with invalid category is added THEN exception is thrown")
    void invalidCategoryItem() {
        assertThrows(IllegalArgumentException.class, () -> shop.addItem((T) new Clothes("jeans", 60, null)));
    }

    @Test
    @DisplayName("WHEN items with category are searched THEN list of items is returned")
    void categoryItems() {
        shop.addItem((T) new Clothes("Shirt", 40, NEW));
        shop.addItem((T) new Clothes("Hat", 15, ON_SALE));
        shop.addItem((T) new Clothes("Jumper", 55, NEW));
        shop.addItem((T) new Clothes("Belt", 10, NEW));
        shop.addItem((T) new Clothes("Shoes", 35, ON_SALE));
        shop.addItem((T) new Clothes("T-Shirt", 12, REFURBISHED));

        assertThat(shop.findByCategory(ON_SALE).size()).isEqualTo(2);
    }

    @Test
    @DisplayName("WHEN items with category are searched but not found THEN empty list is returned")
    void categoryItemsNoResult() {
        shop.addItem((T) new Clothes("Shirt", 40, NEW));
        shop.addItem((T) new Clothes("Hat", 15, ON_SALE));
        shop.addItem((T) new Clothes("Jumper", 55, NEW));
        shop.addItem((T) new Clothes("Belt", 10, NEW));
        shop.addItem((T) new Clothes("Shoes", 35, ON_SALE));

        assertThat(shop.findByCategory(REFURBISHED)).isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("WHEN items lower than a price are searched THEN list of items is returned")
    void itemsByPrice() {
        shop.addItem((T) new Clothes("Shirt", 40, NEW));
        shop.addItem((T) new Clothes("Hat", 15, ON_SALE));
        shop.addItem((T) new Clothes("Jumper", 55, NEW));
        shop.addItem((T) new Clothes("Belt", 10, NEW));
        shop.addItem((T) new Clothes("Shoes", 35, ON_SALE));
        shop.addItem((T) new Clothes("T-Shirt", 12, REFURBISHED));

        assertThat(shop.findWithLowerPrice(20).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("WHEN items lower than a price are searched but not found THEN empty list is returned")
    void noItemsByPrice() {
        shop.addItem((T) new Clothes("Shirt", 40, NEW));
        shop.addItem((T) new Clothes("Hat", 15, ON_SALE));
        shop.addItem((T) new Clothes("Jumper", 55, NEW));
        shop.addItem((T) new Clothes("Belt", 10, NEW));
        shop.addItem((T) new Clothes("Shoes", 35, ON_SALE));

        assertThat(shop.findWithLowerPrice(5)).isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("WHEN an item is searched by name and found THEN the item is returned")
    void findByName() {
        shop.addItem((T) new Clothes("Shirt", 40, NEW));
        shop.addItem((T) new Clothes("Hat", 15, ON_SALE));
        shop.addItem((T) new Clothes("Jumper", 55, NEW));
        shop.addItem((T) new Clothes("Belt", 10, NEW));
        shop.addItem((T) new Clothes("Shoes", 35, ON_SALE));
        shop.addItem((T) new Clothes("T-Shirt", 12, REFURBISHED));

        assertThat(shop.findByName("jumper")).isPresent();
    }

    @Test
    @DisplayName("WHEN an item is searched by name and is not found THEN empty optional is returned")
    void findByNameNoResult() {
        shop.addItem((T) new Clothes("Shirt", 40, NEW));
        shop.addItem((T) new Clothes("Hat", 15, ON_SALE));
        shop.addItem((T) new Clothes("Jumper", 55, NEW));
        shop.addItem((T) new Clothes("Belt", 10, NEW));
        shop.addItem((T) new Clothes("Shoes", 35, ON_SALE));
        shop.addItem((T) new Clothes("T-Shirt", 12, REFURBISHED));

        assertThat(shop.findByName("blazer")).isEmpty();
    }

    @Test
    @DisplayName("WHEN removing an item THEN the item is returned and then removed from the list")
    void removeItem() {
        shop.addItem((T) new Clothes("Shirt", 40, NEW));
        shop.addItem((T) new Clothes("Hat", 15, ON_SALE));
        shop.addItem((T) new Clothes("Jumper", 55, NEW));
        shop.addItem((T) new Clothes("Belt", 10, NEW));
        shop.addItem((T) new Clothes("Shoes", 35, ON_SALE));
        shop.addItem((T) new Clothes("T-Shirt", 12, REFURBISHED));

        assertThat(shop.removeItem("jumper")).isPresent();
        assertThat(shop.getItems().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("WHEN removing an item which is not found THEN empty optional is returned and list stays the same")
    void removeNonExistingItem() {
        shop.addItem((T) new Clothes("Shirt", 40, NEW));
        shop.addItem((T) new Clothes("Hat", 15, ON_SALE));
        shop.addItem((T) new Clothes("Jumper", 55, NEW));
        shop.addItem((T) new Clothes("Belt", 10, NEW));
        shop.addItem((T) new Clothes("Shoes", 35, ON_SALE));
        shop.addItem((T) new Clothes("T-Shirt", 12, REFURBISHED));

        assertThat(shop.removeItem("blazer")).isEmpty();
        assertThat(shop.getItems().size()).isEqualTo(6);
    }

}