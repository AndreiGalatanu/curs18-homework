package ro.fasttrackit.khomework

class Shop<T : ShopItem>(private val items: MutableList<T> = mutableListOf()) {

    fun addItem(item: T) {
        this.items.add(item)
    }

    fun getListOfItems(): List<T> = if (items.isEmpty()) listOf() else items

    fun findByCategory(category: Category): List<T> {
        val result = mutableListOf<T>()
        for (item in items) {
            if (item.category == category) {
                result.add(item)
            }
        }
        return result
    }

    fun findWithLowerPrice(maxPrice: Int): List<T> {
        val result = mutableListOf<T>()
        for (item in items) {
            if (item.price <= maxPrice) {
                result.add(item)
            }
        }
        return result
    }

    fun findByName(name: String): T? {
        for (item in items) {
            if (item.name.toLowerCase() == name.toLowerCase()) {
                return item
            }
        }
        return null
    }

    fun removeItem(name: String): T? {
        val item = findByName(name)
        if (item != null) {
            this.items.remove(item)
            return item
        }
        return null
    }

    fun totalShoppingPrice(): Int {
        var sum = 0
        for (item in items) {
            sum += item.price
        }
        return sum
    }
}