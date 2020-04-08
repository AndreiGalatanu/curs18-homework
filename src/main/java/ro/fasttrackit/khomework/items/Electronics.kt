package ro.fasttrackit.khomework.items

import ro.fasttrackit.khomework.Category
import ro.fasttrackit.khomework.ShopItem

data class Electronics(private val name: String, private val price: Int, private val category: Category) : ShopItem {
    override fun name(): String {
        return name
    }

    override fun price(): Int {
        return price
    }

    override fun category(): Category {
        return category
    }

    override fun toString(): String {
        return "Electronics(name = $name, price = $price, category = $category)"
    }
}