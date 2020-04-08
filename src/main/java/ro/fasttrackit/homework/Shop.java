package ro.fasttrackit.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shop<T extends ShopItem> {
    private List<T> items;

    public Shop() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        this.items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public List<T> findByCategory(Category category) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (item.category().equals(category)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<T> findWithLowerPrice(int maxPrice) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (item.price() <= maxPrice) {
                result.add(item);
            }
        }
        return result;
    }

    public Optional<T> findByName(String name) {
        for (T item : items) {
            if (item.name().equalsIgnoreCase(name)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public Optional<T> removeItem(String name) {
        Optional<T> item = findByName(name);
        if (item.isPresent()) {
            this.items.remove(item.get());
            return item;
        } else {
            return Optional.empty();
        }
    }

    public int totalShoppingPrice() {
        int result = 0;
        for (T item : this.items) {
            result += item.price();
        }
        return result;
    }


}
