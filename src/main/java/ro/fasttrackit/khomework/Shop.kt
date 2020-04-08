package ro.fasttrackit.khomework

class Shop<T : ShopItem>() {
    private var items = mutableListOf<T>()

    fun addItem(item: T) {
        this.items.add(item)
    }

    fun getListOfItems(): MutableList<T> {
        return items
    }

    fun findByCategory(category: Category): MutableList<T> {
        val result = mutableListOf<T>()
        for (item in items) {
            if (item.category() == category) {
                result.add(item)
            }
        }
        return result
    }

    fun findWithLowerPrice(maxPrice: Int): MutableList<T> {
        val result = mutableListOf<T>()
        for (item in items) {
            if (item.price() <= maxPrice) {
                result.add(item)
            }
        }
        return result
    }

    private fun noItemByNameFound(name: String): Nothing {
        throw IllegalArgumentException("No item found: $name")
    }

    fun findByName(name: String): T? {
        for (item in items) {
            if (item.name().toLowerCase() == name.toLowerCase()) {
                return item
            }
        }
        noItemByNameFound(name)
    }

    fun removeItem(name: String): T? {
        val item = findByName(name)
        if (item != null) {
            this.items.remove(item)
            return item
        }
        noItemByNameFound(name)
    }

    fun totalShoppingPrice(): Int {
        var sum = 0
        for (item in items) {
            sum += item.price()
        }
        return sum
    }
}