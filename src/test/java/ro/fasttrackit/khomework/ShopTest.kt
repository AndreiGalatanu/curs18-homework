package ro.fasttrackit.khomework

import org.junit.jupiter.api.Test

import org.assertj.core.api.AssertionsForClassTypes.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import ro.fasttrackit.khomework.Category.*

internal class ShopTest {
    private var clothesShop = Shop<Clothes>()

    @BeforeEach
    fun setup() {
        clothesShop = Shop()
    }

    @Test
    fun `addItemWithInvalidName`() {
        assertThrows<Exception> { clothesShop.addItem(Clothes("", 20, REFURBISHED)) }
    }

    @Test
    fun `addItemWithInvalidPrice`() {
        assertThrows<Exception> { clothesShop.addItem(Clothes("shirt", -20, ON_SALE)) }
    }

    @Test
    fun `getListOfItemsAfterItemsWereAdded`() {
        clothesShop.addItem(Clothes("shirt", 50, ON_SALE))
        clothesShop.addItem(Clothes("jeans", 100, NEW))
        clothesShop.addItem(Clothes("jacket", 270, NEW))
        clothesShop.addItem(Clothes("hat", 20, REFURBISHED))
        clothesShop.addItem(Clothes("belt", 12, REFURBISHED))

        assertThat(clothesShop.getListOfItems().size).isEqualTo(5)
    }

    @Test
    fun `emptyItemsList`() {
        assertThat(clothesShop.getListOfItems().size).isEqualTo(0)
    }

    @Test
    fun `listOfItemsFoundByCategory`() {
        clothesShop.addItem(Clothes("shirt", 50, ON_SALE))
        clothesShop.addItem(Clothes("jeans", 100, NEW))
        clothesShop.addItem(Clothes("jacket", 270, NEW))
        clothesShop.addItem(Clothes("hat", 20, REFURBISHED))
        clothesShop.addItem(Clothes("belt", 12, REFURBISHED))

        assertThat(clothesShop.findByCategory(NEW).size).isEqualTo(2)
    }

    @Test
    fun `noItemsFoundByCategory`() {
        clothesShop.addItem(Clothes("jeans", 100, NEW))
        clothesShop.addItem(Clothes("jacket", 270, NEW))
        clothesShop.addItem(Clothes("hat", 20, REFURBISHED))
        clothesShop.addItem(Clothes("belt", 12, REFURBISHED))

        assertThat(clothesShop.findByCategory(ON_SALE).size).isEqualTo(0)
    }

    @Test
    fun `itemsWithLowerPrice`() {
        clothesShop.addItem(Clothes("shirt", 50, ON_SALE))
        clothesShop.addItem(Clothes("jeans", 100, NEW))
        clothesShop.addItem(Clothes("jacket", 270, NEW))
        clothesShop.addItem(Clothes("hat", 20, REFURBISHED))
        clothesShop.addItem(Clothes("belt", 12, REFURBISHED))

        assertThat(clothesShop.findWithLowerPrice(50).size).isEqualTo(3)
    }

    @Test
    fun `noItemsWithPriceLowerFound`() {
        clothesShop.addItem(Clothes("shirt", 50, ON_SALE))
        clothesShop.addItem(Clothes("jeans", 100, NEW))
        clothesShop.addItem(Clothes("jacket", 270, NEW))
        clothesShop.addItem(Clothes("hat", 20, REFURBISHED))
        clothesShop.addItem(Clothes("belt", 12, REFURBISHED))

        assertThat(clothesShop.findWithLowerPrice(10).size).isEqualTo(0)
    }

    @Test
    fun `itemFoundByName`() {
        clothesShop.addItem(Clothes("shirt", 50, ON_SALE))
        clothesShop.addItem(Clothes("jeans", 100, NEW))
        clothesShop.addItem(Clothes("jacket", 270, NEW))
        clothesShop.addItem(Clothes("hat", 20, REFURBISHED))
        clothesShop.addItem(Clothes("belt", 12, REFURBISHED))

        assertThat(clothesShop.findByName("jeans")).isNotNull
    }

    @Test
    fun `itemNotFoundByName`() {
        clothesShop.addItem(Clothes("shirt", 50, ON_SALE))
        clothesShop.addItem(Clothes("jeans", 100, NEW))
        clothesShop.addItem(Clothes("jacket", 270, NEW))
        clothesShop.addItem(Clothes("hat", 20, REFURBISHED))
        clothesShop.addItem(Clothes("belt", 12, REFURBISHED))

        assertThat(clothesShop.findByName("blazer")).isNull()
    }

    @Test
    fun `successfullyRemovedItem`() {
        clothesShop.addItem(Clothes("shirt", 50, ON_SALE))
        clothesShop.addItem(Clothes("jeans", 100, NEW))
        clothesShop.addItem(Clothes("jacket", 270, NEW))
        clothesShop.addItem(Clothes("hat", 20, REFURBISHED))
        clothesShop.addItem(Clothes("belt", 12, REFURBISHED))

        assertThat(clothesShop.removeItem("jacket")).isNotNull
        assertThat(clothesShop.getListOfItems().size).isEqualTo(4)
    }

    @Test
    fun `itemRemovalUnsuccessful`() {
        clothesShop.addItem(Clothes("shirt", 50, ON_SALE))
        clothesShop.addItem(Clothes("jeans", 100, NEW))
        clothesShop.addItem(Clothes("jacket", 270, NEW))
        clothesShop.addItem(Clothes("hat", 20, REFURBISHED))
        clothesShop.addItem(Clothes("belt", 12, REFURBISHED))

        assertThat(clothesShop.removeItem("blazer")).isNull()
        assertThat(clothesShop.getListOfItems().size).isEqualTo(5)
    }

    @Test
    fun totalShoppingPrice() {
        clothesShop.addItem(Clothes("shirt", 50, ON_SALE))
        clothesShop.addItem(Clothes("jeans", 100, NEW))
        clothesShop.addItem(Clothes("jacket", 270, NEW))
        clothesShop.addItem(Clothes("hat", 20, REFURBISHED))
        clothesShop.addItem(Clothes("belt", 12, REFURBISHED))

        assertThat(clothesShop.totalShoppingPrice()).isEqualTo(452)
    }
}