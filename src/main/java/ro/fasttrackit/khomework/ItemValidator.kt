package ro.fasttrackit.khomework

import java.util.regex.Pattern

class ItemValidator {

    private fun <T> verifyNotNull(t: T) {
        if (t == null || t == "") throw Exception()
    }

    private fun verifyName(name: String) {
        verifyNotNull(name)
        val pattern = Pattern.compile("^[ A-za-z0-9'\\-]+$")
        val matcher = pattern.matcher(name)
        if (!matcher.matches()) throw Exception()
    }

    private fun verifyPrice(price: Int) {
        if (price <= 0) throw Exception()
    }

    private fun verifyCategory(category: Category) {
        verifyNotNull(category)
    }

    fun verify(name: String, price: Int, category: Category) {
        verifyName(name)
        verifyPrice(price)
        verifyCategory(category)
    }
}