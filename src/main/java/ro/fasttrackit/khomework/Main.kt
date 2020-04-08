package ro.fasttrackit.khomework

import ro.fasttrackit.khomework.Category.*
import ro.fasttrackit.khomework.items.Electronics

fun main() {
    val electronicsShop = Shop<Electronics>()

    electronicsShop.addItem(item = Electronics("TV", 1700, ON_SALE))
    electronicsShop.addItem(item = Electronics("PC", 3500, NEW))
    electronicsShop.addItem(item = Electronics("Laptop", 4300, REFURBISHED))
    electronicsShop.addItem(item = Electronics("PS4", 1900, ON_SALE))
    electronicsShop.addItem(item = Electronics("Mobile Phone", 2500, ON_SALE))

    println()
    println(electronicsShop.getListOfItems())
    println()
    println(electronicsShop.findByCategory(ON_SALE))
    println()
    println(electronicsShop.findWithLowerPrice(2000))
    println()
    println(electronicsShop.findByName("laptop"))
    println()
    println(electronicsShop.removeItem("ps4"))
    println()
    println(electronicsShop.getListOfItems())
    println()
    println(electronicsShop.totalShoppingPrice())

}