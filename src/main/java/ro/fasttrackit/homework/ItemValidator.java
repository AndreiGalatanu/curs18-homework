package ro.fasttrackit.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemValidator {
    private void verifyCategory(Category category) {
        verifyNotNull(category);
    }

    private void verifyPrice(int price) {
        if (price <= 0) throw new IllegalArgumentException("invalid price");
    }

    private void verifyName(String name) {
        verifyNotNull(name);
        Pattern pattern = Pattern.compile("^[ A-za-z0-9'\\-]+$");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) throw new IllegalArgumentException("invalid name");
    }

    private <T> void verifyNotNull(T t) {
        if (t == null || t.equals("")) throw new IllegalArgumentException();
    }

    public void verify(String name, int price, Category category) {
        verifyName(name);
        verifyPrice(price);
        verifyCategory(category);
    }
}
