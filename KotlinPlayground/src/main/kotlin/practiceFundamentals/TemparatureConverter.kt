package practiceFundamentals

fun main() {
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5 * (27.0) + 35 }
    printFinalTemperature(350.0, "Kelvin", "Celsius") { (350) - 273.15 }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * ((10.0) - 32) + 273.15}

}


fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

