package ro.fasttrackit.khomework

import ro.fasttrackit.khomework.Category.*

fun main() {
    val electronicsShop = Shop<Electronics>()

    electronicsShop.addItem(Electronics("TV", 1700, ON_SALE))
    electronicsShop.addItem(Electronics("PC", 3500, NEW))
    electronicsShop.addItem(Electronics("Laptop", 4300, REFURBISHED))
    electronicsShop.addItem(Electronics("PS4", 1900, ON_SALE))
    electronicsShop.addItem(Electronics("Mobile Phone", 2500, ON_SALE))

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