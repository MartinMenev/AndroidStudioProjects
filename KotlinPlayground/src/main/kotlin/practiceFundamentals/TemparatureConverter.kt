package practiceFundamentals

fun main() {
    val valueCelsius = 27.0
    val valueKelvin = 350.0
    val valueFahrenheit = 10.0


    printFinalTemperature(valueCelsius, "Celsius", "Fahrenheit") { 9.0 / 5 * valueCelsius + 35 }
    printFinalTemperature(valueKelvin, "Kelvin", "Celsius") { valueKelvin - 273.15 }
    printFinalTemperature(valueFahrenheit, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (valueFahrenheit - 32) + 273.15}

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


