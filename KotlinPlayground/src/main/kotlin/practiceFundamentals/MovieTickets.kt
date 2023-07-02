package practiceFundamentals

fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int? {
   var price: Int = when (age) {
       in 0..12 -> 15
       in 13..60 -> 30
       in 61..100 -> 20
       else -> -1
   }
    if (price == 30 && isMonday) {
        price = 25
    } else if (price == -1) {
        return null
    }

    return price
}