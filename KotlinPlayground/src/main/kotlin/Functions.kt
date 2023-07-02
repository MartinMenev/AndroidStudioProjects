fun main() {

   val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)

    trickFunction()
    repeat(4) {
        treatFunction()
    }
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    return if (isTrick) {
        trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}

