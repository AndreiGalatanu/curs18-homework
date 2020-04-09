package ro.fasttrackit.khomework

interface ShopItem {
    val name: String
    val price: Int
    val category: Category
}

data class Clothes(override val name: String,
                   override val price: Int,
                   override val category: Category) : ShopItem {
    val validator = ItemValidator().verify(name, price, category)
}

data class Electronics(override val name: String,
                       override val price: Int,
                       override val category: Category) : ShopItem {
    val validator = ItemValidator().verify(name, price, category)

}

data class Fruits(override val name: String,
                  override val price: Int,
                  override val category: Category) : ShopItem {
    val validator = ItemValidator().verify(name, price, category)

}
